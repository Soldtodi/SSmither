package api;

import java.awt.Rectangle;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.wrappers.widgets.WidgetChild;

/**
 *
 * @author Peter
 */
public class AmountButton {

    private final WidgetChild widget;
    private final AMOUNTBUTTONS btn;
    
    private AmountButton(WidgetChild widget, AMOUNTBUTTONS btn) {
        this.widget = widget;
        this.btn = btn;
    }
    
    public Rectangle getBounds() {
        return widget.getRectangle();
    }
    
    public String getName() {
        return btn.getName();
    }
    
    public boolean isSelected() {
        return widget.getText().contains("<col=ffffff>");
    }
    
    public boolean interact() {
        return widget.interact();
    }
    
    public boolean isVisible() {
        return widget.isVisible();
    }
    
    public boolean select() {
        return isSelected() || interact();
    }

    public static AmountButton getButton(Widget root, AMOUNTBUTTONS button) {
        if(root != null) {
            for(WidgetChild w : root.getChildren()) {
                if(w != null && w.getChildren() != null) {
                    for(WidgetChild child : w.getChildren()) {
                        if(child != null && child.getText() != null && (button.getName().equals(child.getText()) ||  child.getText().equals("<col=ffffff>"+button.getName()+"</col>"))) {
                            return new AmountButton(child, button);
                        }
                    }
                }
            }
        }
        return null;
    }
    
}
