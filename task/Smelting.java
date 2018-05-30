
package task;

import api.AMOUNTBUTTONS;
import api.BAR;
import static org.dreambot.api.methods.MethodProvider.sleep;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;
import org.dreambot.api.methods.map.Tile;
import api.Smelt;
import org.dreambot.api.script.AbstractScript;

/**
 *
 * @author Peter
 */
public class Smelting extends Task {
    
    private final Smelt smelt;
    private final BAR bar;

    public Smelting(AbstractScript m, BAR bar) {
        super(m);
        
        this.smelt = new Smelt(m);
        this.bar = bar;
        
    }
    
    public BAR getBar() {
        return bar;
    }
    
    public Smelt getSmelt() {
        return smelt;
    }
  
    public boolean hasNeededItems() {
        for(int i = 0; i < getBar().getAmount().length; i++) {
            if(getScript().getInventory().count(getBar().getOres()[i].getName()) < getBar().getAmount()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int run() {
        
        if(!hasNeededItems()) {
            if(openBank()) {

                int multiplier = getMultiplier(getBar());

                if((getScript().getInventory().isEmpty() || getScript().getBank().depositAllItems()) && getScript().getInventory().isEmpty()) {
                    for(int i = 0; i < getBar().getAmount().length; i++) {
                        if(getScript().getInventory().count(getBar().getOres()[i].getName()) == 0) {
                            getScript().getBank().withdraw(getBar().getOres()[i].getName(), getBar().getAmount()[i] * multiplier);
                            sleep(100, 380);
                        }
                        else {
                            getScript().getBank().depositAllItems();
                            return 250;
                        }
                    }
                }
            }
        } else {
            
            if(walkTo(new Tile(2973, 3370, 0), 2)) {
                if(!sleepUntil(() -> {
                    return getScript().getLocalPlayer().isAnimating();
                }, 2000)) {

                    if(getSmelt().open() && getSmelt().isOpen()) {

                        if(getSmelt().getAmountButton(AMOUNTBUTTONS.ALL).select()) {
                            getSmelt().getItem(getBar()).interact();
                        }

                    }
                    
                }
                
            }
            
        }
        return 150;
    }
    
}
