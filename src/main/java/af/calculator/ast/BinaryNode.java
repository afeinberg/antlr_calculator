package af.calculator.ast;

abstract public class BinaryNode extends Node {

    private final Node left;
    private final Node right;

    public BinaryNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
