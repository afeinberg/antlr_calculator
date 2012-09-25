package af.calculator.ast;

public abstract class Visitor<R> {

    public abstract R visitDouble(DoubleNode node);

    public abstract R visitAddition(AdditionNode node);

    public abstract R visitSubtraction(SubtractionNode node);

    public abstract R visitMultiplication(MultiplicationNode node);

    public abstract R visitDivision(DivisionNode node);

    public abstract R visitExponentiation(ExponentiationNode node);

    public abstract R visitUnaryMinus(UnaryMinusNode node);
}
