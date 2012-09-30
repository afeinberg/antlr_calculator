package af.calculator.compiler;

public class CompilerTest extends BaseEvaluatorTest {

    @Override
    protected Evaluator getEvaluator() {
        return new Compiler();
    }
}
