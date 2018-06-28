package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symboltable.SymbolTable;

import java.util.List;

public class For extends ComponentBlock {

    private Assignment maxValue;
    private Assignment stripe;
    private Assignment actual;

    For(ComponentType type, List<Component> components, Method father, Assignment maxValue, Assignment stripe, Assignment actual) {
        super(type, components, father);
        this.maxValue = maxValue;
        this.actual = actual;
        this.stripe = stripe;
    }

    public For(ComponentType type, List<Component> components, Assignment maxValue, Assignment stripe, Assignment actual) {
        super(type, components);
        this.maxValue = maxValue;
        this.stripe = stripe;
        this.actual = actual;
    }

    public Assignment getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Assignment maxValue) {
        this.maxValue = maxValue;
    }

    public Assignment getStripe() {
        return stripe;
    }

    public void setStripe(Assignment stripe) {
        this.stripe = stripe;
    }

    public Assignment getActual() {
        return actual;
    }

    public void setActual(Assignment actual) {
        this.actual = actual;
    }

    public void checkType(SymbolTable symboltable, String methodName) throws Exception{
        if(!this.getActual().getAssignmentType(symboltable).equals(VarType.INT)){
            throw new Exception("Error en "+ methodName+ ": los valores en " + this.getClass().getSimpleName() + " deben ser de tipo int");
        } else if(!this.getStripe().getAssignmentType(symboltable).equals(VarType.INT)){
            throw new Exception("Error en "+ methodName+ ": los valores en " + this.getClass().getSimpleName() + " deben ser de tipo int");
        } else if(!this.getMaxValue().getAssignmentType(symboltable).equals(VarType.INT)){
            throw new Exception("Error en "+ methodName+ ": los valores en "  + this.getClass().getSimpleName() + " deben ser de tipo int");
        }
        super.checkType(symboltable, methodName);
    }

    @Override
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        maxValue.checkSymbolTable(symboltable);
        stripe.checkSymbolTable(symboltable);
        actual.checkSymbolTable(symboltable);
        super.checkSymbolTable(symboltable);
    }

}
