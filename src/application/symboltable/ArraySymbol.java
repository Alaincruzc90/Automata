package application.symboltable;

import application.enums.SymbolTypes;
import application.enums.VarType;

public class ArraySymbol extends Symbols {

    private int size;       //array size
    private VarType type;    //data type

    public ArraySymbol(String name, VarType type){
        super(name);
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public VarType getType() {
        return type;
    }

    public void setType(VarType type) {
        this.type = type;
    }
}
