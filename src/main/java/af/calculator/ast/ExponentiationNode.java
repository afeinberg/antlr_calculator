package af.calculator.ast;

public class ExponentiationNode extends BinaryNode {

    public ExponentiationNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitExponentiation(this);
    }
}
