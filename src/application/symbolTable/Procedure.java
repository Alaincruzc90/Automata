package application.symbolTable;

public class Procedure extends Symbol {

    private String parameter_type;

    public Procedure(String name, String parameter_type){
        super(name);
        this.parameter_type = parameter_type;
    }

    public Procedure(String name, int type, int x, int y){
        super(name);
        parameter_type = "none"; //default value
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getParameter_type() {
        return parameter_type;
    }
}
