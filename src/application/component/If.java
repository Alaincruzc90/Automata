package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

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

    public void checkType(SymbolTable symboltable, String methodName) throws Exception{
        if(this.condition.getLeftEntry() != null && this.condition.getRightEntry() != null){
            if(!this.condition.getLeftEntry().getAssignmentType(symboltable).equals(this.condition.getRightEntry().getAssignmentType(symboltable))){
                throw new Exception("Error en "+ methodName + ": comparación de tipos diferentes en if");
            }
            if(this.elseComponent != null){
                this.elseComponent.checkType(symboltable, methodName);
            }
            super.checkType(symboltable, methodName);
        }
    }

    @Override
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        condition.checkSymbolTable(symboltable);
        super.checkSymbolTable(symboltable);
        if (elseComponent != null) elseComponent.checkSymbolTable(symboltable);
    }

}
