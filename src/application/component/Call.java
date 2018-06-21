package application.component;

import application.assignment.*;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.*;
import application.variables.VarStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception{
        return parameter.getAssignmentType(symbolTable);
    }

    public void checkParameterList(SymbolTable symbolTable, String methodName, Set<VarStructure> parameter) throws Exception{
        if(parameter != null && parameter.size() > 0){

            List<VarStructure> paramList = new LinkedList<>();
            for(VarStructure var: parameter){
                paramList.add(var);
            }

            Symbols symbol = symbolTable.lookupFunc(methodName);
            if(symbol == null){
                symbol = symbolTable.lookupProc(methodName);
            }
            if(symbol != null){
                List<VarType> assignedParameterList = new LinkedList<>();
                if(symbol instanceof Function){
                    assignedParameterList = ((Function) symbol).getVarTypes();
                }
                if(symbol instanceof Procedure){
                    assignedParameterList = ((Procedure) symbol).getVarTypes();
                }

                VarType varType;
                String name;
                for(int i = 0; i < assignedParameterList.size(); i++){
                    name = paramList.get(i).getIdentifierName();
                    symbol = symbolTable.lookupVariable(name);
                    if(symbol != null && symbol instanceof Variable){
                        if(!((Variable) symbol).getType().equals(this.parameter.getAssignmentType(symbolTable))){
                            throw new Exception("Error: parámetros diferentes a los definidos en " + methodName);
                        }
                    }
                }
            }
        }
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

    @Override
    public void checkType(SymbolTable symbolTable) throws Exception {
        //implementado usando metodos propios de la clase
    }
}
