package application.component;

import application.enums.ComponentType;
import application.method.Method;

import java.util.List;

public class ComponentBlock extends Component {

    private List<Component> components;

    public ComponentBlock(ComponentType type, List<Component> components, Method father) {
        super(type, father);
        this.components = components;
    }

    public ComponentBlock(ComponentType type, List<Component> components) {
        super(type);
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public void print(int spaces) {
        String printSpaces = new String(new char[spaces]).replace("\0", "   ");
        System.out.println(printSpaces+"Tipo de instrucción -> " + this.getType());
        if(components != null) {
            for (Component component: components) {
                component.print(spaces+1);
            }
        }
    }
}
