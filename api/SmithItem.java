package api;

import java.awt.Rectangle;
import java.util.Arrays;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.core.Instance;

/**
 *
 * @author Peter
 */
public class SmithItem {

    private final WidgetChild widget;
    private String name;
    private int id;
    //private Rectangle rect;
    
    public SmithItem(Instance inst, WidgetChild widget) {
        this.widget = widget;
        
        if(widget.getActions() != null && Arrays.asList(widget.getActions()).contains("Smith All")) {
            //rect = new Rectangle(widget.getRectangle().x, widget.getRectangle().y, widget.getRectangle().width-5, widget.getRectangle().height-5);
            for(WidgetChild child : widget.getChildren()) {
                if(child != null) {
                    if(child.getItemId() > 0) {
                        id = child.getItemId();
                        name = new Item(id, 1, inst).getName();
                        break;
                    }
                }
            }
        }

    }
    
    public boolean interact(String action) {
        return widget.interact(action);
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
    public Rectangle getBounds() {
        return rect;
    }
    */
    
}
