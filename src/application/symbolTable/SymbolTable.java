package application.symbolTable;

import java.util.LinkedList;
import java.util.List;

public class SymbolTable {

    private List<Symbols> globalSymbols;
    private List<Symbols> localSymbols;

    public SymbolTable() {
        globalSymbols = new LinkedList<>();
        localSymbols = new LinkedList<>();
    }

    public List<Symbols> getGlobalSymbols() {
        return globalSymbols;
    }

    public void setGlobalSymbols(List<Symbols> globalSymbols) {
        this.globalSymbols = globalSymbols;
    }

    public List<Symbols> getLocalSymbols() {
        return localSymbols;
    }

    public void setLocalSymbols(List<Symbols> localSymbols) {
        this.localSymbols = localSymbols;
    }

    public void emptyLocalList() {
        localSymbols.clear();
    }

    public Symbols lookupVariable(String identifier) {
        for(Symbols symbols : globalSymbols) {
            if(symbols instanceof Variable || symbols instanceof ArraySymbols) {
                if(symbols.getName().equals(identifier)) {
                    return symbols;
                }
            }
        }
        for(Symbols symbols : localSymbols) {
            if(symbols instanceof Variable || symbols instanceof ArraySymbols) {
                if(symbols.getName().equals(identifier)) {
                    return symbols;
                }
            }
        }
        return null;
    }

    public Function lookupFunc(String identifier) {
        for(Symbols symbols : globalSymbols) {
            if(symbols instanceof Function) {
                if(symbols.getName().equals(identifier)) {
                    return (Function) symbols;
                }
            }
        }
        for(Symbols symbols : localSymbols) {
            if(symbols instanceof Function) {
                if(symbols.getName().equals(identifier)) {
                    return (Function) symbols;
                }
            }
        }
        return null;
    }

    public Procedure lookupProc(String identifier) {
        for(Symbols symbols : globalSymbols) {
            if(symbols instanceof Procedure) {
                if(symbols.getName().equals(identifier)) {
                    return (Procedure) symbols;
                }
            }
        }
        for(Symbols symbols : localSymbols) {
            if(symbols instanceof Procedure) {
                if(symbols.getName().equals(identifier)) {
                    return (Procedure) symbols;
                }
            }
        }
        return null;
    }
}
