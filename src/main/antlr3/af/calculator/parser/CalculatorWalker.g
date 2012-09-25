tree grammar CalculatorWalker;

options {
	tokenVocab=Calculator;
	ASTLabelType=CommonTree;
}

@header {
	package af.calculator.parser;

	import af.calculator.ast.*;
}

eval returns [Node n]
	: expr {n = $expr.n;}
	;

expr returns [Node n] 
	: ^(PLUS a=expr b=expr) {n = new AdditionNode($a.n, $b.n);}
	| ^(MINUS a=expr b=expr) {n = new SubtractionNode($a.n, $b.n);}
	| ^(MULTIPLY a=expr b=expr) {n = new MultiplicationNode($a.n, $b.n);}
	| ^(DIVIDE a=expr b=expr) {n = new DivisionNode($a.n, $b.n);}
	| ^(POWER a=expr b=expr) {n = new ExponentiationNode($a.n, $b.n);}
	| ^(UNARYMINUS a=expr) {n=new UnaryMinusNode($a.n);}
	| DOUBLE {n = new DoubleNode($DOUBLE.text);}
	;