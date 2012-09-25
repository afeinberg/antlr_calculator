package af.calculator.ast;

public class DivisionNode extends BinaryNode {

    public DivisionNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitDivision(this);
    }
}
