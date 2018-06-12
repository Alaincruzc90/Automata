package application.assignment;

import application.symboltable.SymbolTable;

public class DirectAssignment<K> implements Assignment {

    private K value;

    public DirectAssignment(K value, String identifierName) {
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        // Do nothing
    }
}
