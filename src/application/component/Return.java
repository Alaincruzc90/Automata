package application.component;

import application.assignment.*;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symboltable.Function;
import application.symboltable.SymbolTable;
import application.symboltable.Symbols;

public class Return extends Component implements Assignment {

    private Assignment assignment;

    public Return(ComponentType type, Method father, Assignment value) {
        super(type, father);
        this.assignment = value;
    }

    public Return(ComponentType type, Assignment value) {
        super(type);
        this.assignment = value;
    }

    public Assignment getValue() {
        return assignment;
    }

    public void setValue(Assignment value) {
        this.assignment = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        assignment.checkSymbolTable(symboltable);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symboltable) throws Exception{
        return assignment.getAssignmentType(symboltable);
    }

    @Override
    public void checkType(SymbolTable symboltable, String methodName) throws Exception {
        Symbols symbol = symboltable.lookupFunc(methodName);
        if(symbol != null) {
            VarType returnValueType = ((Function) symbol).getReturnValueType();
            if(returnValueType != null){
                if(! returnValueType.equals(this.getValue().getAssignmentType(symboltable))){
                    throw new Exception("La función " + methodName + " tiene un tipo de retorno no válido");
                }
            }
        } else {
            symbol = symboltable.lookupProc(methodName);
            if(symbol != null){
                throw new Exception("Error: Return en procedimiento " + methodName);
            } else {
                throw new Exception("El método" + methodName + " no fue encontrado en la tabla de símbolos");
            }
        }
    }
}