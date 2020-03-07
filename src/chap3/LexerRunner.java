package chap3;

import chap3.CodeDialog;
import stone.ParseException;
import stone.Token;
import stone.lex;

public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        lex l = new lex(new CodeDialog());
        for(Token t; (t = l.read())!= Token.EOF;)
            System.out.println("=>"+t.getText()+t.isIdentifier()+t.isNumber()+t.isString());
    }
}
