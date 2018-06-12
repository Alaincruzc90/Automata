package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

public class Return extends Component implements Assignment {

    private Assignment assignment;

    public Return(ComponentType type, Method father, Assignment value) {
        super(type, father);
        this.assignment = value;
    }

    public Return(ComponentType type, Assignment value) {
        super(type);
        this.assignment = value;
    }

    public Assignment getValue() {
        return assignment;
    }

    public void setValue(Assignment value) {
        this.assignment = value;
    }

    @Override
    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        assignment.checkSymbolTable(symbolTable);
    }
}
