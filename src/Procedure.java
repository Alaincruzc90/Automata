public class Procedure extends Symbol{

    private String parameter_type;

    public Procedure(String name, int scope, String parameter_type){
        super(name, scope);
        this.parameter_type = parameter_type;
    }

    public Procedure(String name, int scope){
        super(name, scope);
        parameter_type = "none"; //default value
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getScope() {
        return super.getScope();
    }

    public String getParameter_type() {
        return parameter_type;
    }
}
