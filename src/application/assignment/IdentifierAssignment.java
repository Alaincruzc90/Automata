package application.assignment;

import application.enums.VarType;
import application.symboltable.*;

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
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        if(symboltable.lookupVariable(identifier) == null) {
            throw new Exception("No se encontro la variable " + identifier);
        }
    }

    @Override
    public VarType getAssignmentType(SymbolTable symboltable) throws Exception {
        Symbols symbol = symboltable.lookupVariable(this.getIdentifier());
        if(symbol != null){
                if(symbol instanceof Variable){
                    return ((Variable) symbol).getType();
                } else if(symbol instanceof ListSymbols){
                    return VarType.LIST;
                } else if(symbol instanceof ArraySymbols){
                    return VarType.ARRAY;
                }
        } else {
            symbol = symboltable.lookupFunc(this.getIdentifier());
            if(symbol != null){
                return ((Function) symbol).getReturnValueType();
            }
        }
        throw new Exception("La variable " + this.getIdentifier() + " no ha sido declarada.");
    }
}
