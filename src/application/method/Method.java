package application.method;

import application.classobject.ClassObject;
import application.component.Component;
import application.enums.MethodType;
import application.symboltable.ArraySymbol;
import application.symboltable.SymbolTable;
import application.symboltable.Symbols;
import application.symboltable.Variable;
import application.variables.*;

import java.util.*;

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

    public void fillLocalSymbols(SymbolTable symbolTable) throws Exception{

        List list = new ArrayList(parameters);
        Collections.reverse(list);
        Set<VarStructure> resultParameters = new LinkedHashSet<>(list);

        for(VarStructure var : resultParameters) {
            if(var instanceof VarDeclaration) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            }
        }

        List localsList = new ArrayList(localVariables);
        Collections.reverse(localsList);
        Set<VarStructure> resultLocals = new LinkedHashSet<>(localsList);

        for(VarStructure var : resultLocals) {
            if(var instanceof VarDeclaration) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symbolTable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            } else if (var instanceof ArrayDeclaration) {
                symbolTable.getLocalSymbols().add(new ArraySymbol(var.getIdentifierName(), ((ArrayDeclaration) var).getVarType()));
            } else if (var instanceof VarAssignment) {
                Symbols variable = symbolTable.lookupVariable(var.getIdentifierName());
                if (variable == null) {
                    System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada.");
                }
            }
        }

        List componentList = new ArrayList(components);
        Collections.reverse(componentList);
        List<Component> resultComponents = new LinkedList<>(componentList);

        for(Component component : resultComponents) {
            try {
                component.checkSymbolTable(symbolTable);
            } catch (Exception e) {
                throw new Exception("ERROR ----> En el método " + this.identifier + ": " + e.getMessage());
            }
        }
    }
}
