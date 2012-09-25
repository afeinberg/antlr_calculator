package af.calculator.ast;

public class UnaryMinusNode extends Node {

    private final Node child;

    public UnaryMinusNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitUnaryMinus(this);
    }
}
