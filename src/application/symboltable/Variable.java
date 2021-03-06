package application.symboltable;

import application.enums.VarType;

public class Variable extends Symbols {

    private VarType type;

    public Variable(String name, VarType type) {
        super(name);
        this.type = type;
    }

    public VarType getType() {
        return type;
    }

    public void setType(VarType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Variable && this.getName().equals(((Variable) obj).getName()));
    }
}
