package application.component;

import application.assignment.*;
import application.assignment.math.MathOperation;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Func;
import application.method.Method;
import application.symbolTable.Function;
import application.symbolTable.SymbolTable;
import application.symbolTable.Symbols;

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
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        assignment.checkSymbolTable(symbolTable);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception{
        return assignment.getAssignmentType(symbolTable);
    }

    @Override
    public void checkType(SymbolTable symbolTable, String methodName) throws Exception {
        Symbols symbol = symbolTable.lookupFunc(methodName);
        if(symbol != null) {
            VarType returnValueType = ((Function) symbol).getReturnValueType();
            if(returnValueType != null){
                if(! returnValueType.equals(this.getValue().getAssignmentType(symbolTable))){
                    throw new Exception("La función " + methodName + " tiene un tipo de retorno no válido");
                }
            }
        } else {
            symbol = symbolTable.lookupProc(methodName);
            if(symbol != null){
                throw new Exception("Error: Return en procedimiento " + methodName);
            } else {
                throw new Exception("El método" + methodName + " no fue encontrado en la tabla de símbolos");
            }
        }
    }
}
