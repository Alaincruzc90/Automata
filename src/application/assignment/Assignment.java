package application.assignment;


import application.enums.VarType;
import application.symbolTable.SymbolTable;

public interface Assignment {

    void checkSymbolTable(SymbolTable symbolTable) throws Exception;
    VarType getAssignmentType(SymbolTable symbolTable) throws Exception;
}
