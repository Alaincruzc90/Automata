import java.util.Stack;

public class SymbolTable {

    private Stack<Symbol> symbols;
    private int scope;

    public SymbolTable() {
        symbols = new Stack<>();
        scope = 0;
    }

    //se debe revisar push, hay que escoger el constructor adecuado

    public Symbol push(String name) {
        Symbol symbol = new Symbol(name, scope);
        symbols.push(symbol);
        return symbol;
    }

    public Symbol lookup(String name) {
        Symbol symbol;
        for (int i = symbols.size() - 1; i >= 0; i--) {
            symbol = symbols.get(i);
            if (symbol.getName().equals(name)) { // AND symbol.getScope() == scope to know if it's in this scope
                return symbol;
            }
        }
        return null;
    }

    public void beginScope() {
        scope = scope + 1;
    }

    public void endScope() {
        for (int i = symbols.size() - 1; i >= 0; i--) {
            Symbol symbol = symbols.get(i);
            if (symbol.getScope() == scope) {
                symbols.remove(i);
            } else {
                break;
            }
        }
        scope = scope - 1;
    }

}
