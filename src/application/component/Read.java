package application.component;

import application.assignment.IdentifierAssignment;
import application.enums.ComponentType;
import application.method.Method;

public class Read extends Component {

    private IdentifierAssignment identifier;

    public Read(ComponentType type, Method father, IdentifierAssignment identifier) {
        super(type, father);
        this.identifier = identifier;
    }

    public Read(ComponentType type, IdentifierAssignment identifier) {
        super(type);
        this.identifier = identifier;
    }

    public IdentifierAssignment getIdentifier() {
        return identifier;
    }

    public void setIdentifier(IdentifierAssignment identifier) {
        this.identifier = identifier;
    }
}
