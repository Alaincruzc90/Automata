package application.assignment;

import application.symboltable.SymbolTable;

public class IdentifierAssignment implements Assignment {

    private String identifier;

    public IdentifierAssignment(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        if(symbolTable.lookupVariable(identifier) == null) {
            throw new Exception("No se encontro la variable " + identifier);
        }
    }
}
