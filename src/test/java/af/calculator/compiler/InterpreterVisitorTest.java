package af.calculator.compiler;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class InterpreterVisitorTest {

    @Test
    public void testInterpretVisitor() throws Exception {
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter();
        double t_1 = interpreter.interpret(parser.parseExpr("2 + 2"));
        assertEquals(t_1, 4.0);
        double t_2 = interpreter.interpret(parser.parseExpr("2 + 3 * 5"));
        assertEquals(t_2, 17.0);
        double t_3 = interpreter.interpret(parser.parseExpr("(2 + 3) * 5"));
        assertEquals(t_3, 25.0);
        double t_4 = interpreter.interpret(parser.parseExpr("(2 + 3) ^ 2 + 5 * 5"));
        assertEquals(t_4, 50.0);
    }
}
