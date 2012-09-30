package af.calculator.compiler;


public class InterpreterTest extends BaseEvaluatorTest {

    @Override
    protected Evaluator getEvaluator() {
        return new Interpreter();
    }
}
