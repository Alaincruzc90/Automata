package application.assignment;

import application.enums.VarType;
import application.symbolTable.ArraySymbols;
import application.symbolTable.SymbolTable;
import application.symbolTable.Symbols;

public class ArrayAssignment implements Assignment {

    private Assignment value;
    private Assignment pos;
    private String identifier;

    public ArrayAssignment(Assignment value, String identifier, Assignment pos) {
        this.value = value;
        this.identifier = identifier;
        this.pos = pos;
    }

    public Assignment getValue() {
        return value;
    }

    public void setValue(Assignment value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Assignment getPos() {
        return pos;
    }

    public void setPos(Assignment pos) {
        this.pos = pos;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        if (symbolTable.lookupVariable(this.identifier) == null) {
            throw new Exception("No se encontro la variable " + this.identifier);
        }
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception {
        VarType arrayVarType = null;
        Symbols symbol = symbolTable.lookupVariable(this.getIdentifier());
        if(symbol != null && symbol instanceof ArraySymbols){
            arrayVarType = ((ArraySymbols) symbol).getType();
        } else {
            arrayVarType = this.getValue().getAssignmentType(symbolTable);
        }
        return arrayVarType;
    }
}
