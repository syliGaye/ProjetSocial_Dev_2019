package ci.projetSociaux.utils.upLoadUtils;


/**
 * Created by Soumahoro Abdoul Karim.
 */

public class UploadEvent {
   private String eventType = "progress";
   private Object state;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
