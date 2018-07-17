package application.classobject;

import application.component.Component;
import application.component.VarAssignmentComponent;
import application.enums.VarType;
import application.method.Func;
import application.method.Method;
import application.symboltable.*;
import application.variables.*;

import java.util.*;

public class ClassObject {

    private Set<VarStructure> globalVariables;
    private Set<Method> methods;
    private String name;
    private SymbolTable symboltable;

    public ClassObject(Set<VarStructure> globalVariables, Set<Method> methods, String name) {
        if(globalVariables == null) {
            this.globalVariables = new LinkedHashSet<>();
        } else {
            this.globalVariables = globalVariables;
        }
        this.methods = methods;
        this.name = name;
        this.symboltable = new SymbolTable();
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
        //inserta las variales globales en la tabla de símbolos
        for(VarStructure var : globalVariables) {
            if(var instanceof VarDeclaration ) {
                symboltable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symboltable.getGlobalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            } else if (var instanceof ArrayDeclaration) {
                symboltable.getGlobalSymbols().add(new ArraySymbols(var.getIdentifierName(), ((ArrayDeclaration) var).getVarType()));
            } else if (var instanceof ListDeclaration) {
                symboltable.getGlobalSymbols().add(new ListSymbols(var.getIdentifierName(), ((ListDeclaration) var).getVarType()));
            }
        }

        //se revisa que las asignaciones sean del tipo adecuado según fueron declaradas
        for(VarStructure var : globalVariables) {
            if(var instanceof VarDeclarationAssignment) {
                VarType assignmentVarType = ((VarDeclarationAssignment) var).getAssignment().getAssignmentType(symboltable);
                if(assignmentVarType != null){
                    if(!((VarDeclarationAssignment) var).getVarType().equals(assignmentVarType)){
                        throw new Exception(var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                    }
                }
            } else if(var instanceof VarAssignment){
                VarType assignmentType = ((VarAssignment) var).getAssignment().getAssignmentType(symboltable);
                if(assignmentType != null){
                    Symbols symbol = symboltable.lookupVariable(var.getIdentifierName());
                    if(symbol != null){
                        VarType symbolVarType = null;
                        if(symbol instanceof Variable){
                            symbolVarType = ((Variable) symbol).getType();
                        } else if(symbol instanceof ArraySymbols){
                            symbolVarType = ((ArraySymbols) symbol).getType();
                        }
                        if(symbolVarType != null){
                            if(! ((VarAssignment) var).getAssignment().getAssignmentType(symboltable).equals(symbolVarType)){
                                throw new Exception(var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                            }
                        }
                    }
                } else {
                    System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada.");
                }
            }
        }

        //se diferencia entre funciones y procedimientos
        for(Method method : this.methods) {
            //Se agregan las funciones
            if(method instanceof Func) {
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                        symboltable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
                    }
                }
                symboltable.getGlobalSymbols().add(new Function(method.getIdentifier(), ((Func) method).getReturnType(), varTypes));

                //se guardan las variables locales en la tabla de simbolos
                for(VarStructure locVar : method.getLocalVariables()){
                    if(locVar instanceof VarDeclaration ) {
                        symboltable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarDeclarationAssignment) {
                        symboltable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclarationAssignment) locVar).getVarType()));
                    } else if (locVar instanceof ArrayDeclaration) {
                        symboltable.getLocalSymbols().add(new ArraySymbols(locVar.getIdentifierName(), ((ArrayDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof ListDeclaration) {
                        symboltable.getLocalSymbols().add(new ListSymbols(locVar.getIdentifierName(), ((ListDeclaration) locVar).getVarType()));
                    }
                }

                //se revisa que las asignaciones sean del tipo adecuado según fueron declaradas en la función
                for(VarStructure var : method.getLocalVariables()) {
                    if(var instanceof VarDeclarationAssignment) {
                        VarType assignmentVarType = ((VarDeclarationAssignment) var).getAssignment().getAssignmentType(symboltable);
                        if(assignmentVarType != null){
                            if(!((VarDeclarationAssignment) var).getVarType().equals(assignmentVarType)){
                                throw new Exception("En " + method.getIdentifier() + ". " + var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                            }
                        }
                    } else if(var instanceof VarAssignment){
                        VarType assignmentType = ((VarAssignment) var).getAssignment().getAssignmentType(symboltable);
                        if(assignmentType != null){
                            Symbols symbol = symboltable.lookupVariable(var.getIdentifierName());
                            if(symbol != null){
                                VarType symbolVarType = null;
                                if(symbol instanceof Variable){
                                    symbolVarType = ((Variable) symbol).getType();
                                } else if(symbol instanceof ArraySymbols){
                                    symbolVarType = ((ArraySymbols) symbol).getType();
                                }
                                else if(symbol instanceof ListSymbols){
                                    symbolVarType = ((ListSymbols) symbol).getType();
                                }
                                if(symbolVarType != null){
                                    if(! ((VarAssignment) var).getAssignment().getAssignmentType(symboltable).equals(symbolVarType)){
                                        throw new Exception("En " + method.getIdentifier() + ". " + var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                                    }
                                }
                            } else {
                                System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada en " + method.getIdentifier());
                            }
                        }
                    }
                }
            } else {
                //se agregan los procedimientos
                List<VarType> varTypes = new LinkedList<>();
                for(VarStructure var : method.getParameters()) {
                    if(var instanceof VarDeclaration) {
                        varTypes.add(((VarDeclaration) var).getVarType());
                    }
                }
                symboltable.getGlobalSymbols().add(new Procedure(method.getIdentifier(), varTypes));

                Set<VarStructure> localVariables = method.getLocalVariables(); //se guardan las variables locales en la tabla de simbolos
                for(VarStructure locVar : localVariables){
                    if(locVar instanceof VarDeclaration ) {
                        symboltable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof VarDeclarationAssignment) {
                        symboltable.getLocalSymbols().add(new Variable(locVar.getIdentifierName(), ((VarDeclarationAssignment) locVar).getVarType()));
                    } else if (locVar instanceof ArrayDeclaration) {
                        symboltable.getLocalSymbols().add(new ArraySymbols(locVar.getIdentifierName(), ((ArrayDeclaration) locVar).getVarType()));
                    } else if (locVar instanceof ListDeclaration) {
                        symboltable.getLocalSymbols().add(new ListSymbols(locVar.getIdentifierName(), ((ListDeclaration) locVar).getVarType()));
                    }
                }

                //se revisa que las asignaciones sean del tipo adecuado según fueron declaradas en el procedimiento
                for(VarStructure var : localVariables) {
                    if(var instanceof VarDeclarationAssignment) {
                        VarType assignmentVarType = ((VarDeclarationAssignment) var).getAssignment().getAssignmentType(symboltable);
                        if(assignmentVarType != null){
                            if(!((VarDeclarationAssignment) var).getVarType().equals(assignmentVarType)){
                                throw new Exception("En " + method.getIdentifier() + ". " + var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                            }
                        }
                    } else if(var instanceof VarAssignment){
                        VarType assignmentType = ((VarAssignment) var).getAssignment().getAssignmentType(symboltable);
                        if(assignmentType != null){
                            Symbols symbol = symboltable.lookupVariable(var.getIdentifierName());
                            if(symbol != null){
                                VarType symbolVarType = null;
                                if(symbol instanceof Variable){
                                    symbolVarType = ((Variable) symbol).getType();
                                } else if(symbol instanceof ArraySymbols){
                                    symbolVarType = ((ArraySymbols) symbol).getType();
                                }
                                if(symbolVarType != null){
                                    if(! ((VarAssignment) var).getAssignment().getAssignmentType(symboltable).equals(symbolVarType)){
                                        throw new Exception("En " + method.getIdentifier() + ". " + var.getIdentifierName() + ": asignación de tipo de datos diferente al requerido");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("ERROR ----> La variable " + var.getIdentifierName() + " no ha sido declarada en " + method.getIdentifier());
                    }
                }
            }

            //chequeo de componentes de cada método
            List<Component> components = method.getComponents();
            for(Component var: components){
                var.checkType(symboltable, method.getIdentifier());
            }

            //Vacía la tabla de símbolos local
            symboltable.emptyLocalList();
        }

        //print();
    }

}
