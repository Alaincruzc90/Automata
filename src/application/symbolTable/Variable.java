package application.symbolTable;

public class Variable extends Symbol {

    private String v_type;    //data type
    private String attribute;//for instance 'static'

    public Variable(String name, String v_type, String attribute){
        super(name);
        this.v_type = v_type;
        this.attribute = attribute;
    }

    public Variable(String name, int type, String v_type, int x, int y){
        super(name);
        this.v_type = v_type;
        attribute = "none"; //default attribute value
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getType() {
        return v_type;
    }

    public String getAttribute() {
        return attribute;
    }
}
