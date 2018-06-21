package application.assignment;

import application.component.Call;
import application.enums.VarType;
import application.symbolTable.SymbolTable;

public class CallAssignment implements Assignment {

    private Call call;

    public CallAssignment(Call call) {
        this.call = call;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        call.checkSymbolTable(symbolTable);
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        call.typeCheck(symbolTable, name);
    }

    @Override
    public boolean equalType(VarType varType) {
        return call.equalType(varType);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) throws Exception{
        return call.getAssignmentType(symbolTable);
    }
}
