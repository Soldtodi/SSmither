package api;

/**
 *
 * @author Peter
 */
public enum MATERIAL {
    BRONZE("Bronze"),
    //BLURITE("Blurite"),
    IRON("Iron"),
    SILVER("Silver"),
    STEEL("Steel"),
    GOLD("Gold"),
    //LOVAKITE("Lovakite"),
    MITHRIL("Mithril"),
    ADAMANTITE("Adamantite"),
    RUNITE("Runite");
    
    private final String name;

    private MATERIAL(String name) {
    
        this.name = name;
    
    }

    public String getName() {
        return name;
    }
    
}
