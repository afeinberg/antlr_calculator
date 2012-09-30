package af.calculator.compiler;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public abstract class BaseEvaluatorTest {

    private static final Parser PARSER = new Parser();

    abstract protected Evaluator getEvaluator();

    @Test
    public void testEvaluator() throws Exception {
        Evaluator evaluator = getEvaluator();
        double t_1 = evaluator.evaluate(PARSER.parseExpr("2 + 2"));
        assertEquals(t_1, 4.0);
        double t_2 = evaluator.evaluate(PARSER.parseExpr("2 + 3 * 5"));
        assertEquals(t_2, 17.0);
        double t_3 = evaluator.evaluate(PARSER.parseExpr("(2 + 3) * 5"));
        assertEquals(t_3, 25.0);
        double t_4 = evaluator.evaluate(PARSER.parseExpr("(2 + 3) ^ 2 + 5 * 5"));
        assertEquals(t_4, 50.0);
    }
}
