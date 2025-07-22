package sehha;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;
//Zunaira Hamid 2020110167
public class Slot implements Serializable{
    public int id;
    public String time;
    public LocalDate date;
    public boolean isBooked;
    public Service allocatedService;
    public Patient allocatedPatient;

    public Service getAllocatedService() {
        return allocatedService;
    }

    public void setAllocatedService(Service allocatedService) {
        this.allocatedService = allocatedService;
    }

    public Slot( int id, String time, LocalDate date, boolean isBooked,Service allocatedService,Patient allocatedPatient ) {
        
        this.id = id;
        this.time = time;
        this.date = date;
        this.isBooked = isBooked;
        this.allocatedService=allocatedService;
        this.allocatedPatient=allocatedPatient;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public Patient getAllocatedPatient(){
        return allocatedPatient;
    }

    public void setAllocatedPatient(Patient allocatedPatient) {
        this.allocatedPatient = allocatedPatient;
    }
    //LK
}
