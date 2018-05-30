package api;

/**
 *
 * @author Peter
 */

public enum AMOUNTBUTTONS {
    
    ONE("1"),
    FIVE("5"),
    TEN("10"),
    X("X"),
    ALL("All");

    private String name;
    
    private AMOUNTBUTTONS(String name) {
        
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

}
