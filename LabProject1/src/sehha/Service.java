package sehha;
import java.io.Serializable;
//Zunaira Hamid 202110167
public class Service implements Serializable{
public String title;
public int ID;
public int maxSlots;
public int pricePerSlot;

    public Service(String title, int ID, int maxSlots, int pricePerSlot) {
        this.title = title;
        this.ID = ID;
        this.maxSlots = maxSlots;
        this.pricePerSlot = pricePerSlot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public int getPricePerSlot() {
        return pricePerSlot;
    }

    public void setPricePerSlot(int pricePerSlot) {
        this.pricePerSlot = pricePerSlot;
    }
}
