package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;

public class Return extends Component implements Assignment {

    private Assignment assignment;

    public Return(ComponentType type, Method father, Assignment value) {
        super(type, father);
        this.assignment = value;
    }

    public Return(ComponentType type, Assignment value) {
        super(type);
        this.assignment = value;
    }

    public Assignment getValue() {
        return assignment;
    }

    public void setValue(Assignment value) {
        this.assignment = value;
    }
}
