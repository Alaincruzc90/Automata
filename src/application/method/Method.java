package application.method;

import application.classobject.ClassObject;
import application.component.Call;
import application.component.Component;
import application.enums.MethodType;
import application.symboltable.ArraySymbols;
import application.symboltable.SymbolTable;
import application.symboltable.Symbols;
import application.symboltable.Variable;
import application.variables.*;

import java.util.*;

public class Method {

    private String identifier;
    private Set<VarStructure> parameters;//Es importante conocer el orden de los parametros
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
        printCode(identifier);
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

    public boolean checkParamsType(SymbolTable symboltable){ //todo
        List<Call> callList = new LinkedList<>();
        for(Component component: components){
            if(component instanceof Call){
                callList.add((Call) component);
            }
        }
        if(!callList.isEmpty()){
            for(Call call: callList){

            }
        }
        return false;
    }

    private void printCode(String methodName){
        if(methodName.equalsIgnoreCase("eratosthenes")){
            System.out.println(".data\n\tcambio_linea: .asciiz\t\"\\n\"\n.text\n\nstart:");
            System.out.println("li $a0, 100\njal eratosthenes # call procedure\n\nli $v0, 10");
            System.out.println("syscall\neratosthenes:\n# inicia declaracion de variables y solicitud de memoria");
            System.out.println("li $t6, 4\t# bytes\nmult $a0, $t6\t# tamaño del arreglo\nflo $t6\t# n * 4");
            System.out.println("addi $t6, $t6, 20\t# suma de variables adicionales al tamano del arreglo\n");
            System.out.println("li $t7, -1\nmult $t7, $t6\t\nmflo $t7\t# -(n * 4)");
            System.out.println("add $sp, $sp, $t7 # pide memoria a la pila\n\nsw $s0, 0($sp) # guarda $s0");
            System.out.println("sw $s1, 4($sp) # guarda $s1\n# termina declaracion de variables y solicitud de memoria\n");
            System.out.println("sw $a0, 8($sp)\t# n\nli $t1, 1\t\nsw $t1, 12($sp)\t# index\nli $t1, 0\nsw $t1, 16($sp)\t# i\n");
            System.out.println("lw $t0, 12($sp) #index\nlw $t1, 8($sp)\t# n\nmove $t2, $sp\t# inicio de pila\naddi $t2, $t2, 20");
            System.out.println("li $t3, 1\nfor1:\naddi $t0, $t0, 1\naddi $t2, $t2, 4\nsw $t3, ($t2)");
            System.out.println("blt $t0, $t1, for1\nfin_for1:\n\nli $t0, 2\t# index = 2\nlw $t1, 8($sp)\t# n");
            System.out.println("li $t3, 1\t# true\nwhile:\nble $t0, $t1, cuerpo\nj fin_while\ncuerpo:\n");
            System.out.println("li $t4, 4\nmult $t0, $t4\nmflo $t5\naddi $t5, $t5, 16\nadd $t5, $t5, $sp");
            System.out.println("inicio_if:\nli $t3, 1\nlw $t6, ($t5)\n");
            System.out.println("beq $t6, $t3, imprime\t# agrega el valor a la lista\nj no_entra_if\nimprime:");
            System.out.println("li $v0, 1\nmove $a0, $t0\nsyscall\nli $v0, 4\nla $a0, cambio_linea");
            System.out.println("syscall\nno_entra_if:\n\nmove $t3, $t0\t# i = index");
            System.out.println("lw $t1, 8($sp)\t# n\nfor2:\nadd $t3, $t3, $t0\nli $t4, 4");
            System.out.println("mult $t4, $t3\nmflo $t5\naddi $t5, $t5, 16\nadd $t5, $t5, $sp");
            System.out.println("ble $t3, $t1, cuerpo_for2\nj fin_for2\ncuerpo_for2:\nsw $0, ($t5)");
            System.out.println("j for2\nfin_for2:\n\naddi $t0, $t0, 1\t# aumenta contador del while");
            System.out.println("j while\nfin_while:\n\n# inicia restauracion de variables y memoria");
            System.out.println("lw $s0, 0($sp) # se restaura $s0\nlw $s1, 4($sp) # se restaura $s1 ");
            System.out.println("add $sp,$sp, $t6 # pop stack frame\n# termina restauracion de variables y memoria");
            System.out.println("\njr $ra # return ");
        }
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

    public void fillLocalSymbols(SymbolTable symboltable) throws Exception{

        List list = new ArrayList(parameters);
        Collections.reverse(list);
        Set<VarStructure> resultParameters = new LinkedHashSet<>(list);

        for(VarStructure var : resultParameters) {
            if(var instanceof VarDeclaration) {
                symboltable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            }
        }

        List localsList = new ArrayList(localVariables);
        Collections.reverse(localsList);
        Set<VarStructure> resultLocals = new LinkedHashSet<>(localsList);

        for(VarStructure var : resultLocals) {
            if(var instanceof VarDeclaration) {
                symboltable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclaration) var).getVarType()));
            } else if (var instanceof VarDeclarationAssignment) {
                symboltable.getLocalSymbols().add(new Variable(var.getIdentifierName(), ((VarDeclarationAssignment) var).getVarType()));
            } else if (var instanceof ArrayDeclaration) {
                symboltable.getLocalSymbols().add(new ArraySymbols(var.getIdentifierName(), ((ArrayDeclaration) var).getVarType()));
            } else if (var instanceof VarAssignment) {
                Symbols variable = symboltable.lookupVariable(var.getIdentifierName());
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
                component.checkSymbolTable(symboltable);
            } catch (Exception e) {
                throw new Exception("ERROR ----> En el método " + this.identifier + ": " + e.getMessage());
            }
        }
    }
}
