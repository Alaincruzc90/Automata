package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

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

    public void checkType(SymbolTable symboltable, String methodName) throws Exception{
        if(this.condition.getLeftEntry() != null && this.condition.getRightEntry() != null){
            if(this.condition.getLeftEntry().getAssignmentType(symboltable).equals(this.condition.getRightEntry().getAssignmentType(symboltable))){
                throw new Exception("Error en "+ methodName + ": comparación entre tipos de datos diferentes en else if");
            }
            super.checkType(symboltable, methodName);
        } else {
            throw new Exception("Error: condicional sin asignar en " + this.getClass().getSimpleName());
        }
    }
}
