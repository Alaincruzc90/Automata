package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.enums.VarType;
import application.method.Method;
import application.symbolTable.SymbolTable;

public class Print extends Component {

    private Assignment text;

    public Print(ComponentType type, Method father, Assignment text) {
        super(type, father);
        this.text = text;
    }

    public Print(ComponentType type, Assignment text) {
        super(type);
        this.text = text;
    }

    public Assignment getText() {
        return text;
    }

    public void setText(Assignment text) {
        this.text = text;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        text.checkSymbolTable(symbolTable);
    }

    @Override
    public void checkType(SymbolTable symbolTable, String methodName) throws Exception {
        if(this.getText().getAssignmentType(symbolTable).equals(VarType.LIST)){
            throw new Exception("Error en " + methodName + ": tipo de dato Lista no válido en Print");
        }
    }
}
