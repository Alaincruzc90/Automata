package application.assignment.math;

import application.assignment.Assignment;
import application.assignment.IdentifierAssignment;
import application.enums.VarType;
import application.symbolTable.SymbolTable;

public abstract class MathOperation implements Assignment {

    private Assignment leftAssignment;
    private Assignment rightAssignment;

    MathOperation(){}

    MathOperation(Assignment leftAssignment, Assignment rightAssignment) {
        this.leftAssignment = leftAssignment;
        this.rightAssignment = rightAssignment;
    }

    public Assignment getLeftAssignment() {
        return leftAssignment;
    }

    public void setLeftAssignment(Assignment leftAssignment) {
        this.leftAssignment = leftAssignment;
    }

    public Assignment getRightAssignment() {
        return rightAssignment;
    }

    public void setRightAssignment(Assignment rightAssignment) {
        this.rightAssignment = rightAssignment;
    }

    public abstract <K> K operation();

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        leftAssignment.checkSymbolTable(symbolTable);
        rightAssignment.checkSymbolTable(symbolTable);
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {

    }

    @Override
    public boolean equalType(VarType varType) {
        return false;
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception{
        if(leftAssignment.getAssignmentType(symbolTable).equals(rightAssignment.getAssignmentType(symbolTable))){
            return leftAssignment.getAssignmentType(symbolTable);
        }
        return null;
    }
}
