package application.assignment;

import application.enums.VarType;
import application.symbolTable.SymbolTable;

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
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        value.typeCheck(symbolTable, name);
    }

    @Override
    public boolean equalType(VarType varType) {
        return value.equalType(varType);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception {
        return value.getAssignmentType(symbolTable);
    }
}
