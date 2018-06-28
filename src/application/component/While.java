package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

import java.util.List;

public class While extends ComponentBlock {

    private Condition condition;

    public While(ComponentType type, List<Component> components, Method father, Condition condition) {
        super(type, components, father);
        this.condition = condition;
    }

    public While(ComponentType type, List<Component> components, Condition condition) {
        super(type, components);
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void checkType(SymbolTable symboltable, String methodName) throws Exception{
        if(this.condition.getLeftEntry() != null && this.condition.getRightEntry() != null) {
            if (!this.condition.getLeftEntry().getAssignmentType(symboltable).equals(this.condition.getRightEntry().getAssignmentType(symboltable))) {
                throw new Exception("Error en " + methodName +": comparación de tipos diferentes en " + this.getClass().getSimpleName());
            }
            super.checkType(symboltable, methodName);
        } else {
            throw new Exception("Error en "+ methodName + ": valor no asignado en condicional " + this.getClass().getSimpleName());
        }
    }

}
