package stone.ast;

import java.util.Iterator;
import java.util.List;

public class ASTList extends ASTree {
    protected List<ASTree> children;//一组孩子节点

    public ASTList(List<ASTree> list) {
        children = list;
    }

    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('(');
        String sep = "";
        for (ASTree t : children) {
            buffer.append(sep);
            sep = " ";
        }
        return buffer.append(')').toString();
    }

    @Override
    public String location() {
        for (ASTree t : children) {
            String s = t.location();
            if (s != null)
                return s;
        }
        return null;
    }
}
