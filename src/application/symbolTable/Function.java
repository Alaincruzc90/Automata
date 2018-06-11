package application.symbolTable;

public class Function extends Symbol {

    private String parameter_type;
    private String return_value_type;

    public Function(String name, String return_value_type, String parameter_type){
        super(name);
        this.parameter_type = parameter_type;
        this.return_value_type = return_value_type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getParameterType() {
        return parameter_type;
    }

    public String getReturnValueType() {
        return return_value_type;
    }
}
