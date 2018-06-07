public class Variable extends Symbol{

    private String type;    //data type
    private String attribute;//for instance 'static'

    public Variable(String name, int scope,  String type, String attribute){
        super(name, scope);
        this.type = type;
        this.attribute = attribute;
    }

    public Variable(String name, int scope, String type){
        super(name, scope);
        this.type = type;
        attribute = "none"; //default attribute value
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

    public String getAttribute() {
        return attribute;
    }
}
