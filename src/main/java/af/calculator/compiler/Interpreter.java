package af.calculator.compiler;

import af.calculator.ast.Node;

public class Interpreter implements Evaluator {

    @Override
    public double evaluate(Node node) {
        InterpreterVisitor visitor = new InterpreterVisitor();
        return node.accept(visitor);
    }
}
