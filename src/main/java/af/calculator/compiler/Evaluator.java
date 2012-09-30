package af.calculator.compiler;


import af.calculator.ast.Node;

public interface Evaluator {

    public double evaluate(Node node);
}
