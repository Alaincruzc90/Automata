package application.method;

import application.classobject.ClassObject;
import application.component.Component;
import application.enums.MethodType;
import application.symboltable.SymbolTable;
import application.symboltable.Variable;
import application.variables.VarAssignment;
import application.variables.VarDeclaration;
import application.variables.VarDeclarationAssignment;
import application.variables.VarStructure;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Method {

    private String identifier;
    private Set<VarStructure> parameters;
    private Set<VarStructure> localVariables;
    private List<Component> components;
    private MethodType methodType;
    private ClassObject father;

    public Method() {
        this.identifier = null;
        this.parameters = new LinkedHashSet<>();
        this.localVariables = new LinkedHashSet<>();
        this.components = new LinkedList<>();
        this.methodType = null;
        this.father = null;
    }

    public Method(String identifier,
                  Set<VarStructure> parameters,
                  Set<VarStructure> localVariables,
                  List<Component> components,
                  MethodType methodType,
                  ClassObject father) {
        this.identifier = identifier;
        if(parameters == null) {
            this.parameters = new LinkedHashSet<>();
        } else {
            this.parameters = parameters;
        }
        if(localVariables == null) {
            this.localVariables = new LinkedHashSet<>();
        } else {
            this.localVariables = localVariables;
        }
        if (components == null) {
            this.components = new LinkedList<>();
        } else {
            this.components = components;
        }
        this.methodType = methodType;
        this.father = father;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Set<VarStructure> getParameters() {
        return parameters;
    }

    public void setParameters(Set<VarStructure> parameters) {
        this.parameters = parameters;
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

    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    public ClassObject getFather() {
        return father;
    }

    public void setFather(ClassObject father) {
        this.father = father;
    }

    public void print() {
        String spaces = "   ";
        String doubleSpaces = "      ";
        System.out.println(spaces+"Metodo -> " + this.identifier);
        if(localVariables != null) {
            for (VarStructure var:
                    localVariables) {
                System.out.println(doubleSpaces+"Definición de variable -> " + var.getIdentifierName());
            }
        }
        if(components != null) {
            for (Component component:
                    components) {
                component.print(2);
            }
        }
    }

    public void fillLocalSymbols(SymbolTable symbolTable) {

        for(VarStructure var : parameters) {
            if(var instanceof VarDeclaration) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            }
        }

        for(VarStructure var : localVariables) {
            if(var instanceof VarDeclaration) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            } else if (var instanceof VarAssignment) {
                Variable variable = symbolTable.lookupVariable(var.getIdentifierName());
                if (variable == null) {
                    System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada.");
                }
            }
        }

        for(Component component : components) {

        }
    }
}
