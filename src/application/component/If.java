package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;

import java.util.List;

public class If extends ComponentBlock {

    private Condition condition;
    private Component elseComponent;

    public If(ComponentType type, List<Component> components, Method father, Condition condition, Component elseComponent) {
        super(type, components, father);
        this.condition = condition;
        this.elseComponent = elseComponent;
    }

    public If(ComponentType type, List<Component> components, Condition condition, Component elseComponent) {
        super(type, components);
        this.condition = condition;
        this.elseComponent = elseComponent;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Component getElseComponent() {
        return elseComponent;
    }

    public void setElseComponent(Component elseComponent) {
        this.elseComponent = elseComponent;
    }
}
