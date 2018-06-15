package application.assignment;

import application.enums.VarType;
import application.symbolTable.SymbolTable;
import application.symbolTable.Symbols;
import application.symbolTable.Variable;

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
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        // Do nothing
    }

    @Override
    public void typeCheck(SymbolTable symbolTable, String name) throws Exception {
        Symbols symbols = symbolTable.lookupVariable(name);
        if(symbols != null) {
            if(symbols instanceof Variable) {
                String valueTypeStr = value.getClass().getSimpleName();

                switch (((Variable) symbols).getType()){
                    case INT:
                        if(!valueTypeStr.equalsIgnoreCase("float")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    case DOUBLE:
                        if(!valueTypeStr.equalsIgnoreCase("double")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    case STRING:
                        if(!valueTypeStr.equalsIgnoreCase("string")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    case ARRAY:
                        if(!valueTypeStr.equalsIgnoreCase("array")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    case LIST:
                        if(!valueTypeStr.equalsIgnoreCase("list")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    case BOOLEAN:
                        if(!valueTypeStr.equalsIgnoreCase("boolean")){
                            throw new Exception( name + " requiere tipo: " + valueTypeStr + ".");
                        }
                        break;
                    default:
                        throw new Exception( "Default case: " + name + " requiere tipo: " + valueTypeStr + ".");
                }
            }
        }
        // Do nothing
    }

    @Override
    public boolean equalType(VarType varType) {
        String valueTypeStr = value.getClass().getSimpleName();

        switch (varType) {
            case INT:
                if (!valueTypeStr.equalsIgnoreCase("float")) {
                    return false;
                }
                return true;
            case DOUBLE:
                if (!valueTypeStr.equalsIgnoreCase("double")) {
                    return false;
                }
                return true;
            case STRING:
                if (!valueTypeStr.equalsIgnoreCase("string")) {
                    return false;
                }
                return true;
            case ARRAY:
                if (!valueTypeStr.equalsIgnoreCase("array")) {
                    return false;
                }
                return true;
            case LIST:
                if (!valueTypeStr.equalsIgnoreCase("list")) {
                    return false;
                }
                return true;
            case BOOLEAN:
                if (!valueTypeStr.equalsIgnoreCase("boolean")) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }
}
