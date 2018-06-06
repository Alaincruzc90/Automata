package application.method;

import application.classobject.ClassObject;
import application.component.Component;
import application.enums.MethodType;
import application.variables.VarStructure;

import java.util.List;
import java.util.Set;

public class Func extends Method {

    public Func(String identifier, Set<VarStructure> parameters, Set<VarStructure> localVariables, List<Component> components, MethodType methodType, ClassObject father) {
        super(identifier, parameters, localVariables, components, methodType, father);
    }

}
