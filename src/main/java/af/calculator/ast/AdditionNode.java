package af.calculator.ast;

public class AdditionNode extends BinaryNode {

    public AdditionNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitAddition(this);
    }
}
