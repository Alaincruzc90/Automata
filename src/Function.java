import java.util.List;

public class Function extends Symbol{

    //private int total_of_parameters;
    private String parameter_type;
    private String return_value_type;

    public Function(String name, int scope, String return_value_type, String parameter_type){
        super(name, scope);
        this.parameter_type = parameter_type;
        this.return_value_type = return_value_type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getScope() {
        return super.getScope();
    }

    public String getParameterType() {
        return parameter_type;
    }

    public String getReturnValueType() {
        return return_value_type;
    }
}
