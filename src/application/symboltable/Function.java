package application.symbolTable;

import application.enums.VarType;

import java.util.List;

public class Function extends Symbols {

    private List<VarType> varTypes;
    private VarType returnValueType;

    public Function(String name, VarType returnValueType, List<VarType> parameterTypes){
        super(name);
        this.varTypes = parameterTypes;
        this.returnValueType = returnValueType;
    }

    public List<VarType> getVarTypes() {
        return varTypes;
    }

    public void setVarTypes(List<VarType> varTypes) {
        this.varTypes = varTypes;
    }

    public VarType getReturnValueType() {
        return returnValueType;
    }

    public void setReturnValueType(VarType returnValueType) {
        this.returnValueType = returnValueType;
    }
}
