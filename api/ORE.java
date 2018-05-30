/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author Peter
 */
public enum ORE {

    COPPER("Copper ore"),
    TIN("Tin ore"),
    BLURITE("Blurite ore"),
    IRON("Iron ore"),
    SILVER("Silver ore"),
    COAL("Coal ore"),
    GOLD("Gold ore"),
    MITHRIL("Mithril ore"),
    LOVAKITE("Lovakite ore"),
    ADAMANTITE("Adamantite ore"),
    RUNITE("Runite ore");
    
    private final String name;

    private ORE(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}