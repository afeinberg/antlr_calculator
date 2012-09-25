package af.calculator.compiler;

import af.calculator.ast.*;

public class InterpreterVisitor extends Visitor<Double> {

    @Override
    public Double visitDouble(DoubleNode node) {
        return node.getValue();
    }

    @Override
    public Double visitAddition(AdditionNode node) {
        double lhs = node.getLeft().accept(this);
        double rhs = node.getRight().accept(this);
        return lhs + rhs;
    }

    @Override
    public Double visitSubtraction(SubtractionNode node) {
        double lhs = node.getLeft().accept(this);
        double rhs = node.getRight().accept(this);
        return lhs - rhs;
    }

    @Override
    public Double visitMultiplication(MultiplicationNode node) {
        double lhs = node.getLeft().accept(this);
        double rhs = node.getRight().accept(this);
        return lhs * rhs;
    }

    @Override
    public Double visitDivision(DivisionNode node) {
        double lhs = node.getLeft().accept(this);
        double rhs = node.getRight().accept(this);
        return lhs / rhs;
    }

    @Override
    public Double visitExponentiation(ExponentiationNode node) {
        double lhs = node.getLeft().accept(this);
        double rhs = node.getRight().accept(this);
        return Math.pow(lhs, rhs);
    }

    @Override
    public Double visitUnaryMinus(UnaryMinusNode node) {
        double child = node.getChild().accept(this);
        return -child;
    }
}
