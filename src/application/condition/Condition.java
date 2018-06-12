package application.condition;

import application.assignment.Assignment;
import application.enums.ComparatorType;
import application.symboltable.SymbolTable;

public class Condition {

    private Assignment leftEntry;
    private Assignment rightEntry;
    private ComparatorType comparatorType;

    public Condition(Assignment leftEntry, Assignment rightEntry, ComparatorType comparatorType) {
        this.leftEntry = leftEntry;
        this.rightEntry =  rightEntry;
        this.comparatorType = comparatorType;
    }

    public Assignment getLeftEntry() {
        return leftEntry;
    }

    public void setLeftEntry(Assignment leftEntry) {
        this.leftEntry = leftEntry;
    }

    public Assignment getRightEntry() {
        return rightEntry;
    }

    public void setRightEntry(Assignment rightEntry) {
        this.rightEntry = rightEntry;
    }

    public ComparatorType getComparatorType() {
        return comparatorType;
    }

    public void setComparatorType(ComparatorType comparatorType) {
        this.comparatorType = comparatorType;
    }

    public void checkSymbolTable(SymbolTable symbolTable) throws Exception {
        if(leftEntry != null) leftEntry.checkSymbolTable(symbolTable);
        if(rightEntry != null) rightEntry.checkSymbolTable(symbolTable);
    }
}
