package application.symboltable;

import application.enums.VarType;

public class ListSymbols extends Symbols {

    private VarType type;

    public ListSymbols(String name, VarType type) {
        super(name);
        this.type = type;
    }

    public VarType getType() {
        return type;
    }
}
