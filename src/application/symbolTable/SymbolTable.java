package application.symbolTable;

import java.util.LinkedList;
import java.util.List;

public class SymbolTable {

    private List<Symbol> symbols;

    public SymbolTable() {
        symbols = new LinkedList<>();
    }

    public Symbol insert(Symbol symbol) {
        symbols.add(0, symbol);
        return symbol;
    }

    public Symbol lookup(String name) {

        String symbol_name;

        for(int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).getName().equals(name)) {
                return symbols.get(i);
            }
        }
        return null;
    }

    public void beginScope() {
    }

    public void endScope() {
    }

}
