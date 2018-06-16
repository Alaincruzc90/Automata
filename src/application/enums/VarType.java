package application.enums;

public enum VarType {
    INT,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CHAR,
    STRING,
    ARRAY,
    LIST;

    public boolean equals(VarType varType){
        if(varType == VarType.INT && VarType.INT == this){
            return true;
        }
        if(varType == VarType.INT && VarType.DOUBLE == this){
            return true;
        }
        if(varType == VarType.DOUBLE && VarType.INT == this){
            return true;
        }
        if(varType == VarType.DOUBLE && VarType.DOUBLE == this){
            return true;
        }
        if(varType == VarType.INT && VarType.FLOAT == this){
            return true;
        }
        if(varType == VarType.FLOAT && VarType.INT == this){
            return true;
        }
        if(varType == VarType.FLOAT && VarType.FLOAT == this){
            return true;
        }
        if(varType == VarType.STRING && VarType.STRING == this){
            return true;
        }
        if(varType == VarType.LIST && VarType.LIST == this){
            return true;
        }
        if(varType == VarType.BOOLEAN && VarType.BOOLEAN == this){
            return true;
        }
        if(varType == VarType.ARRAY && VarType.ARRAY == this){
            return true;
        }
        if(varType == VarType.CHAR && VarType.CHAR == this){
            return true;
        }
        return false;
    }

}


