package application.component;

import application.assignment.*;
import application.assignment.math.MathOperation;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

public class Return extends Component implements Assignment {

    private Assignment assignment;

    public Return(ComponentType type, Method father, Assignment value) {
        super(type, father);
        this.assignment = value;
    }

    public Return(ComponentType type, Assignment value) {
        super(type);
        this.assignment = value;
    }

    public Assignment getValue() {
        return assignment;
    }

    public void setValue(Assignment value) {
        this.assignment = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        assignment.checkSymbolTable(symbolTable);
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        this.assignment.typeCheck(symbolTable, name);
    }

    @Override
    public boolean equalType(VarType varType) {
        return this.assignment.equalType(varType);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception{
        return assignment.getAssignmentType(symbolTable);
    }
}
