package application.assignment;


import application.enums.VarType;
import application.symboltable.SymbolTable;

public interface Assignment {

    void checkSymbolTable(SymbolTable symboltable) throws Exception;
    VarType getAssignmentType(SymbolTable symboltable) throws Exception;
}