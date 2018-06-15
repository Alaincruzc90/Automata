package application.assignment;


import application.enums.VarType;
import application.symbolTable.SymbolTable;

public interface Assignment {

    void checkSymbolTable(SymbolTable symbolTable) throws Exception;
    void typeCheck(SymbolTable symbolTable, String name) throws Exception;
    boolean equalType(VarType varType);
}
