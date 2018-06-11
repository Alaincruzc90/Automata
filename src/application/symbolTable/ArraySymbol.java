package application.symbolTable;

public class ArraySymbol extends Symbol {

    private int size;       //array size
    private String type;    //data type

    public ArraySymbol(String name, String type){
        super(name);
        this.type = type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
