package chap6;

import javassist.compiler.Lex;
import stone.*;
import stone.ast.ASTree;
import stone.ast.NullStmnt;

public class BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }

    private static void run(BasicParser basicParser, BasicEnv basicEnv) throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree t = basicParser.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r = ((BasicEvaluator.ASTreeEx) t).eval(basicEnv);
                System.out.println("=>" + r);
            }
        }
    }
}
