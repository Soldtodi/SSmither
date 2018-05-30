/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import api.AMOUNTBUTTONS;
import api.BAR;
import api.ITEM;
import static org.dreambot.api.methods.MethodProvider.sleep;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.script.AbstractScript;
import api.Smith;

/**
 *
 * @author Peter
 */
public class Smithing extends Task {
    
    private final Smith smith;
    private final ITEM item;
    private final BAR bar;

    public Smithing(AbstractScript m, Smith smith, ITEM item, BAR bar) {
        super(m);
        this.smith = smith;
        this.item = item;
        this.bar = bar;
    }

    public BAR getBar() {
        return bar;
    }

    public ITEM getItem() {
        return item;
    }

    public Smith getSmith() {
        return smith;
    }

    @Override
    public int run() {
        
        if(getScript().getInventory().count(getBar().getName()) < getItem().getBarCount() || !getScript().getInventory().contains("Hammer")) {
            if(openBank()) {
                if((getScript().getInventory().isEmpty() || getScript().getBank().depositAllItems()) && getScript().getInventory().isEmpty()) {
                    
                    getScript().getBank().withdraw("Hammer");
                    sleep(100, 380);
                    getScript().getBank().withdrawAll(getBar().getName());
                    sleep(400, 856);
                }
            }
        } else {
            
            if(walkTo(new Tile(3187, 3425, 0), 3)) {
                if(!sleepUntil(() -> {
                    return getScript().getLocalPlayer().isAnimating();
                }, 2000)) {

                    if(getSmith().open() && getSmith().isOpen()) {


                        getSmith().make(getItem().getSmithName(), "Smith All");


                    }
                    
                }
                
            }
            
        }
        
        return 150;
    }
    
    
    
}
