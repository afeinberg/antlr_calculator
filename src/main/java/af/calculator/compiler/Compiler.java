package af.calculator.compiler;


import af.calculator.ast.Node;

public class Compiler implements Evaluator {

    @Override
    public double evaluate(Node node) {
        CompilerVisitor visitor = new CompilerVisitor();
        return CompiledExpression.fromCodeBlock(node.accept(visitor), "compiledNode")
                .execute();
    }
}
