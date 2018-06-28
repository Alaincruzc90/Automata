package application.variables;

import application.assignment.Assignment;
import application.enums.DeclarationType;
import application.enums.VarType;
import application.symboltable.SymbolTable;

public class VarAssignment extends VarStructure implements Assignment {

    private Assignment assignment;

    public VarAssignment(DeclarationType declarationType, String identifierName, Assignment assignment) {
        super(declarationType, identifierName);
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        assignment.checkSymbolTable(symboltable);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symboltable) throws Exception {
        return this.assignment.getAssignmentType(symboltable);
    }
}
