package chap3;

import stone.CodeDialog;
import stone.ParseException;
import stone.Token;
import stone.Lexer;

public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        for(Token t; (t = l.read())!= Token.EOF;)
            if(!t.getText().equals("\\n"))
            System.out.println("=>"+t.getText()+"  id:"+t.isIdentifier()+"  num:"+t.isNumber()+"  str:"+t.isString());
    }
}
