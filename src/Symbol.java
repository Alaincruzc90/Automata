public class Symbol {
    private String name;
    private int scope;

    public Symbol(String name, int scope){
        this.name = name;
        this.scope = scope;
    }

    public String getName(){return name;}
    //public void setName(String name){this.name = name;}


    public int getScope() {
        return scope;
    }
}
