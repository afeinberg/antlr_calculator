package af.calculator.compiler;

import af.calculator.ast.*;
import me.qmx.jitescript.CodeBlock;

import static me.qmx.jitescript.CodeBlock.newCodeBlock;
import static me.qmx.jitescript.util.CodegenUtils.p;
import static me.qmx.jitescript.util.CodegenUtils.sig;

public class CompilerVisitor extends Visitor<CodeBlock> {

    @Override
    public CodeBlock visitDouble(DoubleNode node) {
        return newCodeBlock().ldc(node.getValue());
    }

    @Override
    public CodeBlock visitAddition(AdditionNode node) {
        return node.getLeft().accept(this)
                .append(node.getRight().accept(this))
                .dadd();

    }

    @Override
    public CodeBlock visitSubtraction(SubtractionNode node) {
        return node.getLeft().accept(this)
                .append(node.getRight().accept(this))
                .dsub();
    }

    @Override
    public CodeBlock visitMultiplication(MultiplicationNode node) {
        return node.getLeft().accept(this)
                .append(node.getRight().accept(this))
                .dmul();
    }

    @Override
    public CodeBlock visitDivision(DivisionNode node) {
        return node.getLeft().accept(this)
                .append(node.getRight().accept(this))
                .ddiv();
    }

    @Override
    public CodeBlock visitExponentiation(ExponentiationNode node) {
        return node.getLeft().accept(this)
                .append(node.getRight().accept(this))
                .invokestatic(p(Math.class), "pow", sig(double.class, double.class, double.class));
    }

    @Override
    public CodeBlock visitUnaryMinus(UnaryMinusNode node) {
        return node.getChild().accept(this)
                .ldc(-1.0d)
                .dmul();
    }
}
