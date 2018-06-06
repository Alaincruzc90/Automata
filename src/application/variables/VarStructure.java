package application.variables;

import application.enums.DeclarationType;

public class VarStructure {

    private DeclarationType declarationType;
    private String identifierName;

    public VarStructure(DeclarationType declarationType, String identifierName) {
        this.declarationType = declarationType;
        this.identifierName = identifierName;
    }

    public DeclarationType getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(DeclarationType declarationType) {
        this.declarationType = declarationType;
    }

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj instanceof VarStructure) &&
                (((VarStructure) obj).declarationType == DeclarationType.DECLARATION || ((VarStructure) obj).declarationType == DeclarationType.DECLARATION_ASSIGNMENT)) {
            VarStructure comparator = (VarStructure) obj;
            return this.identifierName.equals(comparator.getIdentifierName()) && this.declarationType == comparator.getDeclarationType();
        }
        return false;
    }

}
