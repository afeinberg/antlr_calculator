package af.calculator;

import af.calculator.ast.Node;
import af.calculator.compiler.Interpreter;
import af.calculator.compiler.Parser;

public class Main {

    public static void main(String[] args) throws Exception {
        String expr = System.console().readLine();
        Parser parser = new Parser();
        Node node = parser.parseExpr(expr);
        Interpreter interpreter = new Interpreter();
        System.out.println(" = " + interpreter.interpret(node));
    }
}
