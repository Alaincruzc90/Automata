package application.component;

import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;
import application.symboltable.Symbols;

public abstract class Component {

    private ComponentType type;
    private Method father;

    public Component(ComponentType type, Method father) {
        this.type = type;
        this.father = father;
    }

    public Component(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public Method getFather() {
        return father;
    }

    public void setFather(Method father) {
        this.father = father;
    }

    public void print(int spaces){
        String printSpaces = new String(new char[spaces]).replace("\0", "   ");
        System.out.println(printSpaces+"Tipo de instrucción -> " + this.type);
    }

    public abstract void checkSymbolTable(SymbolTable symbolTable) throws Exception;
}
