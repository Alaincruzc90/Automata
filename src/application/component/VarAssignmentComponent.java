package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;

public class VarAssignmentComponent extends Component {

    private String identifierName;
    private Assignment assignment;

    public VarAssignmentComponent(ComponentType type, Method father, String identifierName, Assignment assignment) {
        super(type, father);
        this.identifierName = identifierName;
        this.assignment = assignment;
    }

    public VarAssignmentComponent(ComponentType type, String identifierName, Assignment assignment) {
        super(type);
        this.identifierName = identifierName;
        this.assignment = assignment;
    }

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
