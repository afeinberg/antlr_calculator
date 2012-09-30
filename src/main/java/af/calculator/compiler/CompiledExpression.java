package af.calculator.compiler;

import me.qmx.jitescript.CodeBlock;
import me.qmx.jitescript.JiteClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static me.qmx.jitescript.util.CodegenUtils.sig;

public class CompiledExpression {

    private final Method computeMethod;

    public static CompiledExpression fromCodeBlock(final CodeBlock codeBlock, String className) {
        JiteClass jiteClass = new JiteClass(className) {
            {
                defineMethod("compute", ACC_PUBLIC | ACC_STATIC, sig(double.class),
                        codeBlock.dreturn());
            }
        };
        Class<?> clazz = new DynamicClassLoader().define(jiteClass);
        return new CompiledExpression(clazz);
    }

    private CompiledExpression(Class<?> clazz) {
        try {
            computeMethod = clazz.getMethod("compute");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + clazz + " has no \"compute\" method!", e);
        }
    }

    public double execute() {
        try {
            return (Double) computeMethod.invoke(null);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getTargetException());
        }
    }
}
