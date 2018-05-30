package api;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.core.Instance;

/**
 *
 * @author Peter
 */
public class SmeltItem {

    private final WidgetChild widget;
    private final WidgetChild interactWidget;
    private final BAR bar;
    private final char hotkey;
    
    private SmeltItem(WidgetChild widget, WidgetChild interactWidget, BAR bar, char hotkey) {
        this.widget = widget;
        this.interactWidget = interactWidget;
        this.bar = bar;
        this.hotkey = hotkey;
    }
    
    public String getName() {
        return bar.getName();
    }
    
    public char getHotkey() {
        return hotkey;
    }
    
    public Rectangle getBounds() {
        return interactWidget.getRectangle();
    }
    
    public boolean interact() {
        return interactWidget.interact();
    }
    
    public static SmeltItem getItem(Widget root, Instance inst, BAR bar) {
        if(root != null) {
            
            ArrayList<WidgetChild> hotkeyList = new ArrayList<>();

            for(WidgetChild w : root.getChildren()) {
                if(w != null && w.getChildren() != null) {
                    
                    if(w.getActions() != null && w.getActions()[0].equals("Smelt")) {
                        for(WidgetChild child : w.getChildren()) {
                            if(child != null && child.getItemId() > 0) {
                                if(new Item(child.getItemId(), 1, inst).getName().equals(bar.getName())) {

                                    Point p = new Point(w.getX(), w.getY()+w.getHeight());
                                    
                                    char htk = '-';
                                    
                                    for(WidgetChild hotkey : hotkeyList) {
                                        if(hotkey.getRectangle().getLocation().equals(p)) {
                                            htk = hotkey.getText().charAt(0);
                                            break;
                                        }
                                    }
                                    
                                    return new SmeltItem(child, w, bar, htk);
                                }
                            }
                        }
                    } else if(w.getActions() == null) {
                        
                        for(WidgetChild child : w.getChildren()) {
                            if(child != null && child.getText() != null && child.getText().length() == 1 && Character.isDigit(child.getText().charAt(0))) {
                                
                                hotkeyList.add(child);
                                    
                            }
                        }
                        
                    }
                    
                    
                }
            }
        }
        return null;
    }
    
}
