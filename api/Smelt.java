package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;

/**
 *
 * @author Peter
 */

public class Smelt {
    
    private final AbstractScript m;
    public final int smeltRoot = 270;

    public Smelt(AbstractScript m) {
        this.m = m;
    }
    
    public SmeltItem[] getAllSmeltItems() {
        Widget root = getRoot();
        if(root != null) {
            return Arrays.asList(BAR.values()).stream().map(e -> SmeltItem.getItem(root, m.getClient().getInstance(), e)).toArray(SmeltItem[]::new);
        }
        return null;
    }
    
    public AmountButton[] getAllAmountButtons() {
        Widget root = getRoot();
        if(root != null) {
            return Arrays.asList(AMOUNTBUTTONS.values()).stream().map(e -> AmountButton.getButton(root, e)).toArray(AmountButton[]::new);
        }
        return null;
    }
    
    public SmeltItem getItem(BAR bar) {
        return SmeltItem.getItem(getRoot(), m.getClient().getInstance(), bar);
    }
    
    public AmountButton getAmountButton(AMOUNTBUTTONS button) {
        return AmountButton.getButton(getRoot(), button);
    }
    
    public boolean isOpen() {
        Widget root = getRoot();
        if(root != null) {
            return root.isVisible();
        }
        return false;
    }
    
    public boolean open() {
        if(isOpen()) return true;
        GameObject obj = m.getGameObjects().closest("Furnace");
        if(obj != null) {
            if(!obj.isOnScreen()) {
                if(obj.distance() >= 9) {
                    m.getWalking().walk(obj);
                } else {
                    m.getCamera().rotateToEntity(obj);
                }
            } else  {
                return obj.interact();
            }
        }
        return false;
    }
    
    /*
    private void getSmithInterface() {
        List<WidgetChild> list = m.getWidgets().getWidgets(w -> w != null && w.getText() != null && w.getText().equals(smithRootText));
        if(list != null) {
            for(WidgetChild child : list) {
                smithRoot = child.getParentID();
                break;
            }
        }
    }
    */
    
    private Widget getRoot() {
        if(smeltRoot == -1) return null;
        return m.getWidgets().getWidget(smeltRoot);
    }
    
}
