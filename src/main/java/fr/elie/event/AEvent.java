package fr.elie.event;

public class AEvent {

    public enum AEventList {
        ON_BUTTON_CLICKED
    }

    private Object source;
    private AEventList type;

    public AEvent(Object source, AEventList type)
    {
        this.source = source;
        this.type = type;
    }

    public Object getSource() {
        return source;
    }

    public AEventList getType() {
        return type;
    }
}
