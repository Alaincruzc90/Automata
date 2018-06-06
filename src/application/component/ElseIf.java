package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;

import java.util.List;

public class ElseIf extends ComponentBlock {

    private Condition condition;

    public ElseIf(ComponentType type, List<Component> components, Method father, Condition condition) {
        super(type, components, father);
        this.condition = condition;
    }

    public ElseIf(ComponentType type, List<Component> components, Condition condition) {
        super(type, components);
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
