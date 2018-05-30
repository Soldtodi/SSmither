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
public enum BAR {
    BRONZE("% bar", MATERIAL.BRONZE, new ORE[] {ORE.COPPER, ORE.TIN}, new int[] { 1, 1 }),
    //BLURITE("% bar", MATERIAL.BLURITE, new ORE[] {ORE.BLURITE}, new int[] { 1 }),
    IRON("% bar", MATERIAL.IRON, new ORE[] {ORE.IRON}, new int[] { 1 }),
    SILVER("% bar", MATERIAL.SILVER, new ORE[] {ORE.SILVER}, new int[] { 1 }),
    STEEL("% bar", MATERIAL.STEEL, new ORE[] {ORE.COAL, ORE.IRON}, new int[] { 2, 1 }),
    GOLD("% bar", MATERIAL.GOLD, new ORE[] {ORE.GOLD}, new int[] { 1 }),
    //LOVAKITE("% bar", MATERIAL.LOVAKITE, new ORE[] {ORE.COAL, ORE.LOVAKITE}, new int[] { 2, 1 }),
    MITHRIL("% bar", MATERIAL.MITHRIL, new ORE[] {ORE.COAL, ORE.MITHRIL}, new int[] { 4, 1 }),
    ADAMANTITE("% bar", MATERIAL.ADAMANTITE, new ORE[] {ORE.COAL, ORE.ADAMANTITE}, new int[] { 6, 1 }),
    RUNITE("% bar", MATERIAL.RUNITE, new ORE[] {ORE.COAL, ORE.RUNITE}, new int[] { 8, 1 });

    private final String name;
    private final MATERIAL mat;
    private final ORE[] ores;
    private final int[] amount;

    private BAR(String name, MATERIAL mat, ORE[] ores, int[] amount) {
        this.name = name;
        this.ores = ores;
        this.amount = amount;
        this.mat = mat;
    }

    public String getName() {
        return name.replace("%", getMaterial().getName());
    }
    
    public MATERIAL getMaterial() {
        return mat;
    }

    public ORE[] getOres() {
        return ores;
    }
    
    public int[] getAmount() {
        return amount;
    }
    
    public static BAR getBarToMaterial(MATERIAL material) {
        for(BAR bar : BAR.values()) {
            if(bar.getMaterial().equals(material)) {
                return bar;
            }
        }
        return null;
    }

}
