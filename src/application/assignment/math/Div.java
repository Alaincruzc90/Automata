package application.assignment.math;

import application.assignment.Assignment;
import application.symboltable.SymbolTable;

public class Div extends MathOperation {

    public Div() {
    }

    public Div(Assignment leftAssignment, Assignment rightAssignment) {
        super(leftAssignment, rightAssignment);
    }

    @Override
    public <K> K operation() {
        return null;
    }

}
