package af.calculator.ast;

public class DoubleNode extends Node {

    private Double value;

    public DoubleNode(String value) {
        this.value = Double.valueOf(value);
    }

    public Double getValue() {
        return value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitDouble(this);
    }
}
