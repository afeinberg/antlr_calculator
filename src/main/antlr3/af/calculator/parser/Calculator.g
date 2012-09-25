grammar Calculator;

options {
	output=AST;
}

tokens {
	UNARYMINUS;
}

@parser::header {
	package af.calculator.parser;
}

@lexer::header {
	package af.calculator.parser;
}

eval
	: expr ;
expr 
	: multExpr 
		( PLUS ^ multExpr
		| MINUS ^ multExpr
		)*
	;

multExpr
	: powerExpr
		(MULTIPLY ^ powerExpr
		|DIVIDE ^ powerExpr
		)*
	;

powerExpr
	: unaryExpr (POWER ^ unaryExpr)?
	;

unaryExpr
	: '-' atom -> ^(UNARYMINUS atom)
	| atom
	;

atom
	: DOUBLE
	| '('! expr ')'!
	;

PLUS: '+' ;
MINUS: '-' ;
MULTIPLY: '*' ;
DIVIDE: '/' ;
POWER: '^' ;
DOUBLE : '-'? '0'..'9'+ ('.' '0'..'9'*)? ;
WS : (' '|'\t'|'\r'|'\n')+ {skip();} ;