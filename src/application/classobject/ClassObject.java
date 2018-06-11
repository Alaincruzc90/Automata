package application.classobject;

import application.enums.VarType;
import application.method.Func;
import application.method.Method;
import application.symboltable.*;
import application.variables.VarDeclaration;
import application.variables.VarDeclarationAssignment;
import application.variables.VarStructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ClassObject {

    private Set<VarStructure> globalVariables;
    private Set<Method> methods;
    private String name;
    private SymbolTable symbolTable;

    public ClassObject(Set<VarStructure> globalVariables, Set<Method> methods, String name) {
        this.globalVariables = globalVariables;
        this.methods = methods;
        this.name = name;
        this.symbolTable = new SymbolTable();
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

    public void fillSymbolTable() {

        for(VarStructure var : globalVariables) {
            if(var instanceof VarDeclaration ) {
                symbolTable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symbolTable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            }
        }

        for(Method method : methods) {
            if(method instanceof Func) {
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                    }
                }
                symbolTable.getGlobalSymbols().add(new Function(method.getIdentifier(), ((Func) method).getReturnType(), varTypes));
            } else {
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                    }
                }
                symbolTable.getGlobalSymbols().add(new Procedure(method.getIdentifier(), varTypes));
            }
        }

        for (Method method : methods) {
            method.fillLocalSymbols(symbolTable);
            //TODO code generator
            symbolTable.emptyLocalList();
        }



    }
}
