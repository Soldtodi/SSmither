package api;

import java.util.Arrays;
import java.util.List;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.widgets.WidgetChild;

/**
 *
 * @author Peter
 */
public class Smith {
    
    private final AbstractScript m;
    
    private final int smithRoot = 312;
    //private final String smithRootText = "What would you like to make?";

    public Smith(AbstractScript m) {
        this.m = m;
    }
    
    public boolean make(String name, String action) {
        
        SmithItem item = getItem(name);

        if(item != null) {
            return item.interact(action);
        }
        
        return false;
    }
    
    public SmithItem getItem(String name) {
        Widget root = getRoot();
        SmithItem item;
        if(root != null) {
            for(WidgetChild child : root.getChildren()) {
                if(child != null) {
                    item = new SmithItem(m.getClient().getInstance(), child);
                    if(item.getName() != null && item.getName().toLowerCase().contains(name.toLowerCase())) {
                        return item;
                    }
                }
            }
        }
        return null;
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
        GameObject anvil = m.getGameObjects().closest("Anvil");
        if(anvil != null) {
            if(!anvil.isOnScreen()) {
                if(anvil.distance() >= 9) {
                    m.getWalking().walk(anvil);
                } else {
                    m.getCamera().rotateToEntity(anvil);
                }
            } else  {
                return anvil.interact();
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
        if(smithRoot == -1) return null;
        return m.getWidgets().getWidget(smithRoot);
    }
    
}
