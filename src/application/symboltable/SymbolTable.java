package application.symboltable;

import application.enums.SymbolTypes;

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
}
