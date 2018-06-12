package application.variables;

import application.assignment.Assignment;
import application.enums.DeclarationType;
import application.enums.VarType;

public class ArrayDeclaration extends VarStructure {

    private VarType varType;
    private Assignment pos;

    public ArrayDeclaration(DeclarationType declarationType, String identifierName, VarType varType, Assignment pos) {
        super(declarationType, identifierName);
        this.varType = varType;
        this.pos = pos;
    }

    public VarType getVarType() {
        return varType;
    }

    public void setVarType(VarType varType) {
        this.varType = varType;
    }

    public Assignment getPos() {
        return pos;
    }

    public void setPos(Assignment pos) {
        this.pos = pos;
    }
}
