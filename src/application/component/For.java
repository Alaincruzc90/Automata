package application.component;

import application.assignment.Assignment;
import application.assignment.IdentifierAssignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

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

    public void checkType(SymbolTable symbolTable) throws Exception{
        if(!this.getActual().getAssignmentType(symbolTable).equals(VarType.INT)){
            throw new Exception("Error: los valores en " + this.getClass().getSimpleName() + " deben ser de tipo INT");
        } else if(!this.getStripe().getAssignmentType(symbolTable).equals(VarType.INT)){
            throw new Exception("Error: los valores en " + this.getClass().getSimpleName() + " deben ser de tipo INT");
        } else if(!this.getMaxValue().getAssignmentType(symbolTable).equals(VarType.INT)){
            throw new Exception("Error: los valores en " + this.getClass().getSimpleName() + " deben ser de tipo INT");
        }
        for(Component component: this.getComponents()){
            component.checkType(symbolTable);
        }
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        maxValue.checkSymbolTable(symbolTable);
        stripe.checkSymbolTable(symbolTable);
        actual.checkSymbolTable(symbolTable);
        super.checkSymbolTable(symbolTable);
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        super.typeCheck(symbolTable, name);
    }


}
