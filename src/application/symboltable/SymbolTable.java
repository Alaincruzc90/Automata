package application.symboltable;

import application.enums.SymbolTypes;
import application.enums.VarType;

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
        for(Symbols symbol : globalSymbols) {
            if(symbol instanceof Variable || symbol instanceof ArraySymbol) {
                if(symbol.getName().equals(identifier)) {
                    return symbol;
                }
            }
        }
        for(Symbols symbol : localSymbols) {
            if(symbol instanceof Variable || symbol instanceof ArraySymbol) {
                if(symbol.getName().equals(identifier)) {
                    return symbol;
                }
            }
        }
        return null;
    }

    public Function lookupFunc(String identifier) {
        for(Symbols symbol : globalSymbols) {
            if(symbol instanceof Function) {
                if(symbol.getName().equals(identifier)) {
                    return (Function) symbol;
                }
            }
        }
        for(Symbols symbol : localSymbols) {
            if(symbol instanceof Function) {
                if(symbol.getName().equals(identifier)) {
                    return (Function) symbol;
                }
            }
        }
        return null;
    }

    public Procedure lookupProc(String identifier) {
        for(Symbols symbol : globalSymbols) {
            if(symbol instanceof Procedure) {
                if(symbol.getName().equals(identifier)) {
                    return (Procedure) symbol;
                }
            }
        }
        for(Symbols symbol : localSymbols) {
            if(symbol instanceof Procedure) {
                if(symbol.getName().equals(identifier)) {
                    return (Procedure) symbol;
                }
            }
        }
        return null;
    }
}
