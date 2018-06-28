package application.assignment;

import application.enums.VarType;
import application.symbolTable.SymbolTable;
import application.symbolTable.Symbols;
import application.symbolTable.Variable;


public class DirectAssignment<K> implements Assignment {

    private K value;

    public DirectAssignment(K value, String identifierName) {
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        // Do nothing
    }

    @Override
    public VarType getAssignmentType(SymbolTable symbolTable) {
        String valueTypeStr = value.getClass().getSimpleName();
        if(valueTypeStr.equalsIgnoreCase("float")){
            return VarType.INT;
        } else if(valueTypeStr.equalsIgnoreCase("double")){
            return VarType.DOUBLE;
        } else if(valueTypeStr.equalsIgnoreCase("string")){
            return VarType.STRING;
        } else if(valueTypeStr.equalsIgnoreCase("array")) {
            return VarType.ARRAY;
        } else if(valueTypeStr.equalsIgnoreCase("list")){
            return VarType.LIST;
        } else if(valueTypeStr.equalsIgnoreCase("boolean")){
            return VarType.BOOLEAN;
        }
        return null;
    }
}
