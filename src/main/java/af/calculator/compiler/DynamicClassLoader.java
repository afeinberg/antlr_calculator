package af.calculator.compiler;


import me.qmx.jitescript.JiteClass;

public class DynamicClassLoader extends ClassLoader {

    public Class<?> define(JiteClass jiteClass) {
        byte[] classBytes = jiteClass.toBytes();
        return super.defineClass(jiteClass.getClassName(), classBytes, 0, classBytes.length);
    }
}
