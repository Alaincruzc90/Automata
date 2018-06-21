package application.assignment;

import application.enums.VarType;
import application.symbolTable.*;

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

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        //System.out.println("revisando tipo de dato");
    }

    @Override
    public boolean equalType(VarType varType) {
        return false;
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception {
        Symbols symbol = symbolTable.lookupVariable(this.getIdentifier());
        if(symbol != null && symbol instanceof Variable) {
            return ((Variable) symbol).getType();
        } else{
            symbol = symbolTable.lookupFunc(this.getIdentifier());
            if(symbol != null && symbol instanceof Function){
                return ((Function) symbol).getReturnValueType();
            }
        }
        throw new Exception("La variable " + this.getIdentifier() + " no ha sido declarada.");
    }
}
