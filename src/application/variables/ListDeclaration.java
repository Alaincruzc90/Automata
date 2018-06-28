package application.variables;

import application.enums.DeclarationType;
import application.enums.VarType;

public class ListDeclaration extends VarStructure{

    private VarType varType;

    public ListDeclaration(DeclarationType declarationType, String identifierName, VarType varType) {
        super(declarationType, identifierName);
        this.varType = varType;
    }

    public VarType getVarType() {
        return varType;
    }

    public void setVarType(VarType varType) {
        this.varType = varType;
    }
}
