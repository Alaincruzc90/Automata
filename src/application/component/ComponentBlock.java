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
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {

    }

    @Override
    public void checkType(SymbolTable symbolTable) throws Exception {
        System.out.println("bloque de codigo");
        for(Component component: this.getComponents()){
            component.checkType(symbolTable);
            /*if(component instanceof Else){
                component.checkType(symbolTable);
            } else if(component instanceof ElseIf){
                component.checkType(symbolTable);
            } else if(component instanceof For){

            } else if(component instanceof If){

            } else if(component instanceof While){

            }*/
        }
    }
}

