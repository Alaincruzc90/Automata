package application.component;

import application.assignment.Assignment;
import application.enums.ComponentType;
import application.method.Method;
import application.symboltable.SymbolTable;

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
}
