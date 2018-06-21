package application.component;

import application.enums.ComponentType;
import application.method.Method;
import application.symbolTable.SymbolTable;

import java.util.List;

public class Else extends ComponentBlock {

    public Else(ComponentType type, List<Component> components, Method father) {
        super(type, components, father);
    }

    public Else(ComponentType type, List<Component> components) {
        super(type, components);
    }

    public void checkType(SymbolTable symbolTable) throws Exception{
        for(Component component: this.getComponents()){
            component.checkType(symbolTable);
        }
    }
}
