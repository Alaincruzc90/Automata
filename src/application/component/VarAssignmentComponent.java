package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symboltable.ArraySymbols;
import application.symboltable.SymbolTable;
import application.symboltable.Symbols;
import application.symboltable.Variable;

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
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        if(symboltable.lookupVariable(identifierName) == null) {
            throw new Exception("No se encontro la variable " + identifierName);
        }
    }

    @Override
    public void checkType(SymbolTable symboltable, String methodName) throws Exception {
        Symbols symbol = symboltable.lookupVariable(this.getIdentifierName());
        if(symbol != null){
            VarType symbolVarType = null;
            if(symbol instanceof Variable){
                symbolVarType = ((Variable) symbol).getType();
            } else if(symbol instanceof ArraySymbols){
                symbolVarType = ((ArraySymbols) symbol).getType();
            }
            if(symbolVarType != null && this.getAssignment().getAssignmentType(symboltable) != null){
                if(!symbolVarType.equals(this.getAssignment().getAssignmentType(symboltable))){
                    throw new Exception("Error en "+ methodName + ": el tipo de dato asignado es diferente al requerido en variable " + symbol.getName());
                }
            }
        }
    }
}
