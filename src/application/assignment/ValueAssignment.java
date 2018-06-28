package application.assignment;

import application.enums.VarType;
import application.symboltable.SymbolTable;

public class ValueAssignment<K> implements Assignment {

    private K value;

    public ValueAssignment(K value) {
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symboltable) throws Exception {
        // Do nothing
    }

    @Override
    public VarType getAssignmentType(SymbolTable symboltable) {
        String valueTypeStr = value.getClass().getSimpleName();
        if(valueTypeStr.equalsIgnoreCase("float")){
            return VarType.INT;
        } else if(valueTypeStr.equalsIgnoreCase("double")){
            return VarType.INT;
        } else if(valueTypeStr.equalsIgnoreCase("string")){
            return VarType.STRING;
        } else if(valueTypeStr.equalsIgnoreCase("array")) {
            return VarType.ARRAY;
        } else if(valueTypeStr.equalsIgnoreCase("list")){
            return VarType.LIST;
        } else if(valueTypeStr.equalsIgnoreCase("boolean")){
            return VarType.BOOLEAN;
        } else if(valueTypeStr.equalsIgnoreCase("integer")){
            return VarType.INT;
        }
        return null;
    }
}
