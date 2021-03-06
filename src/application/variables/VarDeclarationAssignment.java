package application.variables;

import application.assignment.Assignment;
import application.enums.DeclarationType;
import application.enums.VarType;

public class VarDeclarationAssignment extends VarStructure {

    private VarType varType;
    private Assignment assignment;

    public VarDeclarationAssignment(DeclarationType declarationType, String identifierName, VarType varType, Assignment assignment) {
        super(declarationType, identifierName);
        this.varType = varType;
        this.assignment = assignment;
    }

    public VarType getVarType() {
        return varType;
    }

    public void setVarType(VarType varType) {
        this.varType = varType;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

}
