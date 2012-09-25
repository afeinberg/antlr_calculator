package af.calculator.compiler;

import af.calculator.ast.Node;
import af.calculator.parser.CalculatorLexer;
import af.calculator.parser.CalculatorParser;
import af.calculator.parser.CalculatorWalker;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


public class Parser {

    public Node parseExpr(String expr) throws RecognitionException {
        ANTLRStringStream input = new ANTLRStringStream(expr);
        TokenStream tokens = new CommonTokenStream(new CalculatorLexer(input));
        CalculatorParser parser = new CalculatorParser(tokens);
        CalculatorParser.expr_return ret = parser.expr();
        CommonTree tree = (CommonTree) ret.getTree();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        CalculatorWalker walker = new CalculatorWalker(nodes);
        return walker.eval();
    }
}
