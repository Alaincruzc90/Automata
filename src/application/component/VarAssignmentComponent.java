package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

public class VarAssignmentComponent extends Component {

    private String identifierName;
    private Assignment assignment;

    public VarAssignmentComponent(ComponentType type, Method father, String identifierName, Assignment assignment) {
        super(type, father);
        this.identifierName = identifierName;
        this.assignment = assignment;
    }

    public VarAssignmentComponent(ComponentType type, String identifierName, Assignment assignment) {
        super(type);
        this.identifierName = identifierName;
        this.assignment = assignment;
    }

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        if(symbolTable.lookupVariable(identifierName) == null) {
            throw new Exception("No se encontro la variable " + identifierName);
        }
    }
}
