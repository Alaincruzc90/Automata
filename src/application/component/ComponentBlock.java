package application.component;

import application.assignment.IdentifierAssignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public class ComponentBlock extends Component {

    private List<Component> components;

    public ComponentBlock(ComponentType type, List<Component> components, Method father) {
        super(type, father);
        if(components == null) {
            this.components = new LinkedList<>();
        } else {
            this.components = components;
        }
    }

    public ComponentBlock(ComponentType type, List<Component> components) {
        super(type);
        if(components == null) {
            this.components = new LinkedList<>();
        } else {
            this.components = components;
        }
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

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        for(Component component: components) {
            component.checkSymbolTable(symbolTable);
        }
    }

    @Override
    public void checkType(SymbolTable symbolTable, String methodName) throws Exception {
        for(Component component: components){
            component.checkType(symbolTable, methodName);
        }
    }
}

