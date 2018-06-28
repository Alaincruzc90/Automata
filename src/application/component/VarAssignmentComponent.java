package application.component;

import application.assignment.ArrayAssignment;
import application.assignment.Assignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.ArraySymbols;
import application.symbolTable.SymbolTable;
import application.symbolTable.Symbols;
import application.symbolTable.Variable;

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

    @Override
    public void checkType(SymbolTable symbolTable, String methodName) throws Exception {
        Symbols symbol = symbolTable.lookupVariable(this.getIdentifierName());
        if(symbol != null){
            VarType symbolVarType = null;
            if(symbol instanceof Variable){
                symbolVarType = ((Variable) symbol).getType();
            } else if(symbol instanceof ArraySymbols){
                symbolVarType = ((ArraySymbols) symbol).getType();
            }
            if(symbolVarType != null && this.getAssignment().getAssignmentType(symbolTable) != null){
                if(!symbolVarType.equals(this.getAssignment().getAssignmentType(symbolTable))){
                    throw new Exception("Error en "+ methodName + ": el tipo de dato asignado es diferente al requerido en variable " + symbol.getName());
                }
            }
        }
    }
}
