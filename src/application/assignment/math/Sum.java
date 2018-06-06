package application.assignment.math;

import application.assignment.Assignment;

public class Sum extends MathOperation {

    public Sum() {
    }

    public Sum(Assignment leftAssignment, Assignment rightAssignment) {
        super(leftAssignment, rightAssignment);
    }

    @Override
    public <K> K operation() {
        return null;
    }
}
