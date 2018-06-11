package application.method;

import application.classobject.ClassObject;
import application.component.Component;
import application.enums.MethodType;
import application.enums.VarType;
import application.variables.VarStructure;

import java.util.List;
import java.util.Set;

public class Func extends Method {

    private VarType returnType;

    public Func(String identifier, Set<VarStructure> parameters, Set<VarStructure> localVariables, List<Component> components, MethodType methodType, ClassObject father, VarType returnType) {
        super(identifier, parameters, localVariables, components, methodType, father);
        this.returnType = returnType;
    }

    public VarType getReturnType() {
        return returnType;
    }

    public void setReturnType(VarType returnType) {
        this.returnType = returnType;
    }
}
