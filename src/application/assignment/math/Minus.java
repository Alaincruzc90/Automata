package application.assignment.math;

import application.assignment.Assignment;
import application.enums.VarType;

public class Minus extends MathOperation {

    public Minus() {
    }

    public Minus(Assignment leftAssignment, Assignment rightAssignment) {
        super(leftAssignment, rightAssignment);
    }

    @Override
    public <K> K operation() {
        return null;
    }

}
