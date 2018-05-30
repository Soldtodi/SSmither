package task;

import api.BAR;
import org.dreambot.api.methods.MethodContext;
import static org.dreambot.api.methods.MethodProvider.sleep;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.container.impl.bank.BankType;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.Entity;

/**
 *
 * @author Peter
 */
public abstract class Task {

    private final AbstractScript m;
    private String status = "";
    
    public Task(AbstractScript m) {
        this.m = m;
        
        
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public int getMultiplier(BAR bar) {
        
        int amount = 0;
        for(int am : bar.getAmount()) {
            amount += am;
        }
        amount = 28 / amount;
        
        return amount;
    }
    
    public boolean walkTo(Tile pos, int radius) {  
        if(pos != null) {
            if(pos.distance() > 3+radius) {
                Area ar = pos.getArea(radius);
                if(ar != null) {
                    getScript().getWalking().walk(ar.getRandomTile());
                    if(getScript().getWalking().isRunEnabled()) {
                        sleep(800, 1200);
                    } else {
                        sleep(1200, 2400);
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }
    
    public boolean openBank() {
        if(getScript().getBank().isOpen()) {
            return true;
        } else {
            Entity ent = getScript().getBank().getClosestBank(BankType.BOOTH);
            if(ent != null && ent.distance() < 6) {
                return ent.interact("Bank") && sleepUntil(() -> { return getScript().getBank().isOpen(); }, 2500);
            } else {
                BankLocation loc = getScript().getBank().getClosestBankLocation();
                if(loc != null) {
                    walkTo(loc.getCenter(), 2);
                }
            }
        } 
        return false;
    }
    
    public abstract int run();

    public AbstractScript getScript() {
        return m;
    }

}
