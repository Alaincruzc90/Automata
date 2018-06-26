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
        boolean isEqual = false;
        if(varType == VarType.INT && VarType.INT == this){
            isEqual = true;
        }else if(varType == VarType.INT && VarType.DOUBLE == this){
            isEqual = true;
        }else if(varType == VarType.DOUBLE && VarType.INT == this){
            isEqual = true;
        }else if(varType == VarType.DOUBLE && VarType.DOUBLE == this){
            isEqual = true;
        }else if(varType == VarType.INT && VarType.FLOAT == this){
            isEqual = true;
        }else if(varType == VarType.FLOAT && VarType.INT == this){
            isEqual = true;
        }else if(varType == VarType.FLOAT && VarType.FLOAT == this){
            isEqual = true;
        }else if(varType == VarType.STRING && VarType.STRING == this){
            isEqual = true;
        }else if(varType == VarType.LIST && VarType.LIST == this){
            isEqual = true;
        }else if(varType == VarType.BOOLEAN && VarType.BOOLEAN == this){
            isEqual = true;
        }else if(varType == VarType.ARRAY && VarType.ARRAY == this){
            isEqual = true;
        }else if(varType == VarType.CHAR && VarType.CHAR == this){
            isEqual = true;
        }
        return isEqual;
    }

}


