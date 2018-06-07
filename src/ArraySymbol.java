public class ArraySymbol extends  Symbol{

    private int size;       //array size
    private String type;    //data type

    public ArraySymbol(String name, int scope, String type, int size){
        super(name, scope);
        this.size = size;
        this.type = type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getScope() {
        return super.getScope();
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
