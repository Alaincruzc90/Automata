package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

public class Call extends Component implements Assignment {

    private Assignment parameter;
    private String methodName;

    public Call(ComponentType type, Method father, Assignment parameter, String methodName) {
        super(type, father);
        this.parameter = parameter;
        this.methodName = methodName;
    }

    public Call(ComponentType type, Assignment parameter, String methodName) {
        super(type);
        this.parameter = parameter;
        this.methodName = methodName;
    }

    public Assignment getParameter() {
        return parameter;
    }

    public void setParameter(Assignment parameter) {
        this.parameter = parameter;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        if(symbolTable.lookupFunc(this.methodName) == null && symbolTable.lookupProc(this.methodName) == null) {
            throw new Exception("No se encontro el método " + this.methodName + ".");
        }
        if(parameter != null) {
            parameter.checkSymbolTable(symbolTable);
        }
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        parameter.typeCheck(symbolTable, this.methodName);
    }

    @Override
    public boolean equalType(VarType varType) {
        return parameter.equalType(varType);
    }

}
