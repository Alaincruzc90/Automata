package application.assignment.math;

import application.assignment.Assignment;
import application.symboltable.SymbolTable;

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
}
