package application.component;

import application.condition.Condition;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

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

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        condition.checkSymbolTable(symbolTable);
        super.checkSymbolTable(symbolTable);
        if (elseComponent != null) elseComponent.checkSymbolTable(symbolTable);
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        super.typeCheck(symbolTable, name);
    }

    @Override
    public boolean equalType(VarType varType) {
        return super.equalType(varType);
    }
}
