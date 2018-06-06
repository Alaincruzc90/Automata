package application.classobject;

import application.method.Method;
import application.variables.VarStructure;

import java.util.HashSet;
import java.util.Set;

public class ClassObjectBlock {

    private Set<VarStructure> globalVariables;
    private Set<Method> methods;

    public ClassObjectBlock(){
        this.globalVariables = new HashSet<>();
        this.methods = new HashSet<>();
    }

    public ClassObjectBlock(Set<Method> methods) {
        this.globalVariables = new HashSet<>();
        this.methods = methods;
    }

    public ClassObjectBlock(Set<VarStructure> globalVariables, Set<Method> methods) {
        this.globalVariables = globalVariables;
        this.methods = methods;
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

}
