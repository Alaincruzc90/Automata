package application.symbolTable;

import application.enums.VarType;

import java.util.List;

public class Procedure extends Symbols {

    private List<VarType> varTypes;

    public Procedure(String name, List<VarType> parameterTypes){
        super(name);
        this.varTypes = parameterTypes;
    }

    public List<VarType> getVarTypes() {
        return varTypes;
    }

    public void setVarTypes(List<VarType> varTypes) {
        this.varTypes = varTypes;
    }
}
