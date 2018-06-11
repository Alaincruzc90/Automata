package application.symboltable;

import application.enums.SymbolTypes;

public class ArraySymbol extends Symbols {

    private int size;       //array size
    private SymbolTypes type;    //data type

    public ArraySymbol(String name, SymbolTypes type){
        super(name);
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SymbolTypes getType() {
        return type;
    }

    public void setType(SymbolTypes type) {
        this.type = type;
    }
}
