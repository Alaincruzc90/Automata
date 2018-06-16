package application.classobject;

import application.assignment.ArrayAssignment;
import application.assignment.Assignment;
import application.assignment.IdentifierAssignment;
import application.component.Component;
import application.component.Return;
import application.enums.VarType;
import application.method.Func;
import application.method.Method;
import application.symbolTable.*;
import application.variables.*;

import java.util.*;

public class ClassObject {

    private Set<VarStructure> globalVariables;
    private Set<Method> methods;
    private String name;
    private SymbolTable symbolTable;

    public ClassObject(Set<VarStructure> globalVariables, Set<Method> methods, String name) {
        if(globalVariables == null) {
            this.globalVariables = new LinkedHashSet<>();
        } else {
            this.globalVariables = globalVariables;
        }
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
            if(var instanceof VarAssignment) {
                System.out.println("Assignación de variable -> " + var.getIdentifierName());
            } else {
                System.out.println("Definición de variable -> " + var.getIdentifierName());
            }
        }
        for (Method method:
                methods) {
            method.print();
        }
    }

    public void fillSymbolTable() throws Exception {
        List list = new ArrayList(globalVariables);
        Collections.reverse(list);
        Set<VarStructure> resultGlobals = new LinkedHashSet<>(list);

        for(VarStructure var : resultGlobals) {
            if(var instanceof VarDeclaration ) {
                symbolTable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symbolTable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            } else if (var instanceof ArrayDeclaration) {
                symbolTable.getGlobalSymbols().add(new ArraySymbols(var.getIdentifierName(), ((ArrayDeclaration) var).getVarType()));
            } else if (var instanceof VarAssignment) {
                Symbols variable = symbolTable.lookupVariable(var.getIdentifierName());
                if (variable == null) {
                    System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada.");
                }
            }
        }

        for(VarStructure var : resultGlobals) {
            if(var instanceof VarDeclarationAssignment) {
                VarType assignmentVarType = ((VarDeclarationAssignment) var).getAssignment().getAssignmentType(symbolTable);
                if(assignmentVarType != null){
                    if(!((VarDeclarationAssignment) var).getVarType().equals(assignmentVarType)){
                        throw new Exception(var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                    }
                }
            } else if(var instanceof VarAssignment){
                System.out.println(var.getIdentifierName() + " encontrada como VarAssignment");
            }
        }

        List methodList = new ArrayList(methods);
        Collections.reverse(methodList);
        Set<Method> resultMethods = new LinkedHashSet<>(methodList);

        for(Method method : resultMethods) {
            if(method instanceof Func) {
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                    }
                }
                symbolTable.getGlobalSymbols().add(new Function(method.getIdentifier(), ((Func) method).getReturnType(), varTypes));

                List localVarList = new ArrayList(method.getLocalVariables());
                Collections.reverse(localVarList);
                Set<VarStructure> localVariables = new LinkedHashSet<>(localVarList); //se guardan las variables locales en la tabla de simbolos

                for(VarStructure locVar : localVariables){
                    if(locVar instanceof VarDeclaration ) {
                        symbolTable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarDeclarationAssignment) {
                        symbolTable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclarationAssignment) locVar).getVarType()));
                    } else if (locVar instanceof ArrayDeclaration) {
                        symbolTable.getLocalSymbols().add(new ArraySymbols(locVar.getIdentifierName(), ((ArrayDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarAssignment) {
                        Symbols variable = symbolTable.lookupVariable(locVar.getIdentifierName());
                        if (variable == null) {
                            System.out.println("ERROR ----> La variable " + locVar.getIdentifierName() + " no ha sido declarada.");
                        }
                    }
                }
            } else {
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                    }
                }
                symbolTable.getGlobalSymbols().add(new Procedure(method.getIdentifier(), varTypes));

                Set<VarStructure> localVariables = method.getLocalVariables(); //se guardan las variables locales en la tabla de simbolos
                for(VarStructure locVar : localVariables){
                    if(locVar instanceof VarDeclaration ) {
                        symbolTable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarDeclarationAssignment) {
                        symbolTable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclarationAssignment) locVar).getVarType()));
                    } else if (locVar instanceof ArrayDeclaration) {
                        symbolTable.getLocalSymbols().add(new ArraySymbols(locVar.getIdentifierName(), ((ArrayDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarAssignment) {
                        Symbols variable = symbolTable.lookupVariable(locVar.getIdentifierName());
                        if (variable == null) {
                            System.out.println("ERROR ----> La variable " + locVar.getIdentifierName() + " no ha sido declarada.");
                        }
                    }
                }
            }
        }
        for(Method method2: resultMethods){
            if(method2 instanceof Func){
                if(!((Func) method2).checkReturnValueType(symbolTable)){
                    throw new Exception("Error en tipo de retorno en función " + method2.getIdentifier());
                }
            }
            if(!method2.checkParamsType(symbolTable)){
                throw new Exception("Error en chequeo de parámetros en método " + method2.getIdentifier());
            }
        }


        for (Method method : methods) {
            method.fillLocalSymbols(symbolTable);
            //TODO code generator
            symbolTable.emptyLocalList();
        }
        //-------------******--------------
        print();
    }

}
