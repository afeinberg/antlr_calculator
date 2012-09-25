package af.calculator.ast;

public class SubtractionNode extends BinaryNode {

    public SubtractionNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitSubtraction(this);
    }
}
