package application.assignment;

import application.component.Call;
import application.enums.VarType;
import application.symboltable.SymbolTable;

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
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        call.checkSymbolTable(symboltable);
    }

    @Override
    public VarType getAssignmentType(SymbolTable symboltable) throws Exception{
        return call.getAssignmentType(symboltable);
    }
}
