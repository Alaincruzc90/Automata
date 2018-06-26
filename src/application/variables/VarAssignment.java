package application.variables;

import application.assignment.Assignment;
import application.enums.DeclarationType;
import application.enums.VarType;
import application.symbolTable.SymbolTable;

public class VarAssignment extends VarStructure implements Assignment {

    private Assignment assignment;

    public VarAssignment(DeclarationType declarationType, String identifierName, Assignment assignment) {
        super(declarationType, identifierName);
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        assignment.checkSymbolTable(symbolTable);
    }

    /*@Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        this.assignment.typeCheck(symbolTable, name);
    }*/

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception {
        return this.assignment.getAssignmentType(symbolTable);
    }
}
