package af.calculator.compiler;

import af.calculator.ast.Node;

public class Interpreter {

    public double interpret(Node node) {
        InterpreterVisitor visitor = new InterpreterVisitor();
        return node.accept(visitor);
    }
}
