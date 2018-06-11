package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;

public class Call extends Component implements Assignment {

    private Assignment parameter;
    private String methodName;

    public Call(ComponentType type, Method father, Assignment parameter, String methodName) {
        super(type, father);
        this.parameter = parameter;
        this.methodName = methodName;
    }

    public Call(ComponentType type, Assignment parameter, String methodName) {
        super(type);
        this.parameter = parameter;
        this.methodName = methodName;
    }

    public Assignment getParameter() {
        return parameter;
    }

    public void setParameter(Assignment parameter) {
        this.parameter = parameter;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public void checkSymbolTable() {

    }
}
