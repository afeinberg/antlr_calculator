package af.calculator.ast;

public class MultiplicationNode extends BinaryNode {

    public MultiplicationNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitMultiplication(this);
    }
}
