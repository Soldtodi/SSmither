import api.AMOUNTBUTTONS;
import api.AmountButton;
import api.BAR;
import api.ITEM;
import api.ORE;
import api.Smelt;
import api.SmeltItem;
import api.Smith;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dreambot.api.input.mouse.destination.impl.shape.RectangleDestination;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.container.impl.bank.BankType;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.Entity;
import task.Smithing;
import task.Task;

/**
 *
 * @author Peter
 */

@ScriptManifest(author = "Soldtodie", category = Category.SMITHING, description = "Smith and Smelt anything, enywhere!", name = "SSmither", version = 0.1)

public class SSmither extends AbstractScript {

    ArrayList<Task> tasks;
    
    private Smith smith;
    private Smelt smelt;
    
    @Override
    public void onStart() {
        
        smith = new Smith(this);
        smelt = new Smelt(this);
        
        tasks = new ArrayList<>();
        
        tasks.add(new Smithing(this, getSmith(), ITEM.AXE, BAR.STEEL));
        
    }
    
    private Smith getSmith() {
        return smith;
    }
    
    private Smelt getSmelt() {
        return smelt;
    }
    
    boolean firstMake = false;

    Rectangle worldRectangle;
    
    BAR currBar = BAR.BRONZE;
    

    
    @Override
    public int onLoop() {
        
        if(tasks.size() > 0) {
            
            return tasks.get(0).run();
            
        } else {
            log("Finished all tasks!");
            stop();
        }
        return 1500;
        
        
        //log(walkTo(new Tile(2973, 3370, 0), 2)+ "");
        
        //log("" + getSmelt().getItem(BAR.RUNITE).getHotkey());
        
        /*
        AmountButton btn = getSmelt().getAmountButton(AmountButtons.ALL);
        if(btn != null) {
            if(btn.isSelected()) {
                log("Selected!");
            } else {
                log("Not selected!");
                btn.interact();
            }
        }
        */
        
        /*
        if(!getInventory().contains("Steel bar")) {
            log("Banking made!");
            return 2000;
        }
        
        if(firstMake) {
           if(!sleepUntil(() -> { return getLocalPlayer().isAnimating(); }, 2000) ) {
               firstMake = false;
           }
        } else {
            if(getSmith().open()) {

                if(getSmith().isOpen()) {
                    if(getSmith().make("dagger", "Smith All")) {
                        firstMake = true;
                    }
                } else {
                    sleepUntil(() -> {
                        return getSmith().isOpen();
                    }, 2000);

                    sleepUntil(() -> {
                        return getSmith().isOpen() || getGameObjects().closest("Anvil").isOnScreen() || !getLocalPlayer().isMoving();
                    }, 7000);

                    return 10;
                }
        
            }
        }
        */

        //return 150;
    }
    

    
    

    @Override
    public void onPaint(Graphics graphics) {
        if(tasks.size() > 0) {
            
            graphics.setColor(Color.YELLOW);
            
            graphics.drawString(tasks.get(0).getStatus(), 50, 50);
            
        }
    }

    @Override
    public void onExit() {
        
        
        
    }

}
