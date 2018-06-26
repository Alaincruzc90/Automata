package application.component;

import application.assignment.IdentifierAssignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

public class Read extends Component {

    private IdentifierAssignment identifier;

    public Read(ComponentType type, Method father, IdentifierAssignment identifier) {
        super(type, father);
        this.identifier = identifier;
    }

    public Read(ComponentType type, IdentifierAssignment identifier) {
        super(type);
        this.identifier = identifier;
    }

    public IdentifierAssignment getIdentifier() {
        return identifier;
    }

    public void setIdentifier(IdentifierAssignment identifier) {
        this.identifier = identifier;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        identifier.checkSymbolTable(symbolTable);
    }

    @Override
    public void checkType(SymbolTable symbolTable, String methodName) throws Exception {
        //implementado usando metodos propios de la clase
    }
}
