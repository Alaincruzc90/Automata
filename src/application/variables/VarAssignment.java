package application.variables;

import application.assignment.Assignment;
import application.component.Component;
import application.enums.DeclarationType;
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
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        assignment.checkSymbolTable(symbolTable);
    }
}
