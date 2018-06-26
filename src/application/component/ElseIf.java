package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.method.Method;
import application.symbolTable.SymbolTable;

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

    public void checkType(SymbolTable symbolTable, String methodName) throws Exception{
        if(this.condition.getLeftEntry() != null && this.condition.getRightEntry() != null){
            if(this.condition.getLeftEntry().getAssignmentType(symbolTable).equals(this.condition.getRightEntry().getAssignmentType(symbolTable))){
                throw new Exception("Error en "+ methodName + ": comparación entre tipos de datos diferentes en else if");
            }
            super.checkType(symbolTable, methodName);
        } else {
            throw new Exception("Error: condicional sin asignar en " + this.getClass().getSimpleName());
        }

    }
}
