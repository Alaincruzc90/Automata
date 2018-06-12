package application.method;

import application.component.Component;
import application.variables.VarStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MethodBlock {

    private Set<VarStructure> localVariables;
    private List<Component> components;

    public MethodBlock(Set<VarStructure> localVariables, List<Component> components) {
        this.localVariables = localVariables;
        if(components == null) {
            this.components = new LinkedList<>();
        } else {
            this.components = components;
        }
    }

    public Set<VarStructure> getLocalVariables() {
        return localVariables;
    }

    public void setLocalVariables(Set<VarStructure> localVariables) {
        this.localVariables = localVariables;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
