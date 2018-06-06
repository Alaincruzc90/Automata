package application.classobject;

import application.method.Method;
import application.variables.VarStructure;

import java.util.HashSet;
import java.util.Set;

public class ClassObject {

    private Set<VarStructure> globalVariables;
    private Set<Method> methods;
    private String name;

    public ClassObject(Set<VarStructure> globalVariables, Set<Method> methods, String name) {
        this.globalVariables = globalVariables;
        this.methods = methods;
        this.name = name;
    }

    public ClassObject() {
    }

    public Set<VarStructure> getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(Set<VarStructure> globalVariables) {
        this.globalVariables = globalVariables;
    }

    public Set<Method> getMethods() {
        return methods;
    }

    public void setMethods(Set<Method> methods) {
        this.methods = methods;
    }

    public void print() {
        System.out.println("Clase -> " + this.name);
        String space = "    ";
        for (VarStructure var:
             globalVariables) {
            System.out.println("Definición de variable -> " + var.getIdentifierName());
        }
        for (Method method:
                methods) {
            method.print();
        }
    }
}
