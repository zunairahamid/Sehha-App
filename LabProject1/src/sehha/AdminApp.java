package sehha;
//Zunaira Hamid
import java.time.LocalDate;

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
public class AdminApp implements Serializable {
    ArrayList<Patient>patients=new ArrayList<Patient>();
    ArrayList<Service>services=new ArrayList<Service>();
    ArrayList<Slot>slots=new ArrayList<Slot>();
    public String addPatient(Patient P){
        patients.add(P);
        return "Patient added successfully!";
    }
    public String deletePatient(int qid){
        for(Patient p:patients){
            if(p.getPid()==qid){
                patients.remove(p);
                return "Patient deleted successfully!";
            }
           
        }
       return "Patient not found!";
      }
    
    public ArrayList<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	public ArrayList<Slot> getSlots() {
		return slots;
	}
	public void setSlots(ArrayList<Slot> slots) {
		this.slots = slots;
	}
	public Patient findPatient(int qid) {
		/* Patient lol=null; */
        for (Patient p : patients) {
            	if(p.getPid()==qid) {
            		return p;
            	}
            
    }
        return null;
    }
    public String addService(Service s){
        services.add(s);
        return "Service added successfully!";
    }
    public String addSlot(Slot s) {
    	slots.add(s);
    	return "Slot added successfully!";
    }
   public String modifyService(int ID){
	   String modify=null;
        for(Service s:services){
            if(s.getID()==ID){
           
                String choice;
                Scanner kb=new Scanner(System.in);
                System.out.println("What do you want to modify in the service? a) ID  " +
                        "b) Title" +
                        "c) Maximum Slots" +
                        "d) Price per Slots ");
                choice= kb.nextLine();
                switch (choice) {
                case "a":
                    System.out.println("Enter new ID: ");
                     int mid=kb.nextInt() ;
                    s.setID(mid);
                    break;
                case "b":
                    System.out.println("Enter new title: ");
                   String mtitle=kb.next();
                   s.setTitle(mtitle);
                    break;
                case "c":
                	System.out.println("Enter new maximum slots");
                	int mmax=kb.nextInt();
                	s.setMaxSlots(mmax);
                	break;
                case "d":
                	System.out.println("Enter new price per slot");
                	int mprice=kb.nextInt();
                	s.setPricePerSlot(mprice);
                	break;
                	
                default:
                    modify="Patient not updated.";
            }
            modify="Service updated successfully";
        }
   }
     return modify;   
   }
   public String deleteService(int ID){
        for(Service s:services){
            if(s.getID()==ID){
                services.remove(s);
                return "Service deleted successfully!";
            }

        }
       return "Service not found!";
   }
public Service findService(String ServTitle){
	
        for(Service s:services){
            if(s.getTitle().equalsIgnoreCase(ServTitle)){
            return s;
        }
        
}
        return null;
}
public String addEmptySlot(){
        Slot s=null;
        boolean isBooked=false;
        slots.add(s);
        isBooked=true;
        return "Slot added successfully!";

}
public ArrayList<Slot>getAvailableSlotsPerServiceByDate(int serviceID, LocalDate date){
        ArrayList<Slot>slotsdate=new ArrayList<Slot>();
        for(Slot s:slots){
            if(s.getDate().isEqual(date)&&s.getId()==serviceID){
                slotsdate.add(s);
            }
        }
        return slotsdate;
}

    public ArrayList<Slot> getAvailableSlots() {
        ArrayList<Slot>availableslots=new ArrayList<Slot>();
        for(Slot s:slots){
            if(s.isBooked()){
                availableslots.add(s);
            }
        }
        return availableslots;
    }
    public String deleteSlot(int serviceID, LocalDate date, LocalTime time){
        for(Slot s:slots){
            if(s.getAllocatedService().getID()==serviceID&&s.getDate().isEqual(date)&&time.toString().equals(s.getTime())){
                slots.remove(s);
                return "Slot deleted successfully";
            }
        }
       return "No slots found!";
    }
public ArrayList<Slot>findSlotsbyDate(LocalDate date){
        ArrayList<Slot>dateslot=new ArrayList<Slot>();
        for(Slot s:slots){
            if(s.getDate().isEqual(date)){
                dateslot.add(s);
            }
        }
        return dateslot;
}
public boolean isSlotAvailable(String ServTitle, LocalDate date, LocalTime time){
	for(Slot s: slots){
            if(s.isBooked()&&s.getAllocatedService().getTitle().equalsIgnoreCase(ServTitle)&&time.toString().equalsIgnoreCase(s.getTime())){
                return true;
            }
           
        }
        return false;
}
public ArrayList<Slot>getServiceSlotsStatus(LocalDate date, String ServTitle){
        ArrayList<Slot>serviceslots=new ArrayList<Slot>();
        for(Slot s:slots){
            if(s.getAllocatedService().getTitle().equalsIgnoreCase(ServTitle)&&s.getDate().isEqual(date)){
                serviceslots.add(s);
            }
        }
        return serviceslots;
}
//LK
public String modifyPatientInfo(Patient patient) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What would you like to modify?");
    System.out.println("1. Name");
    System.out.println("2. Residency Type");
    int choice = scanner.nextInt();
    scanner.nextLine();
    switch (choice) {
        case 1:
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            patient.setName(newName);
            break;
        case 2:
            System.out.println("Enter new residency type: ");
            String newResidencyType = scanner.nextLine();
            patient.setResidencyType(newResidencyType);
            break;
        default:
            return "Patient not updated.";
    }
    return "Patient updated successfully";
}
  
       
        // Constructor
       
        // Method to display all slots
		/*
		 * public void displayAllSlots() { System.out.println("All Slots:");
		 * System.out.println("Slot ID\t\t\tStart Time\t\tEnd Time\t\tAvailable"); for
		 * (Slot slot : slots) { System.out.printf("%20s%20s%20s%20s\n", slot.getId(),
		 * slot.getTime(), slot.isBooked()); } }
		 */
        // Method to display all services
		/*
		 * public void displayAllServices() { System.out.println("All Services:");
		 * System.out.
		 * println("Service ID\tService Name\t\tMaximum Slots\tPrice per Slot"); for
		 * (Service service : services) { System.out.println(
		 * service.getID()+service.getTitle()+
		 * service.getMaxSlots()+service.getPricePerSlot()); } }
		 */
public void displayBookings() {
    // Loop through all services
    for (Service service : services) {
        System.out.println(service.getTitle() + " bookings:");
        System.out.println("Patient\t\tSlot\t\tStatus");
        // Loop through all patients
        for (Patient patient : patients) {
            // Loop through all slots
            for (Slot slot : slots) {
                // If the slot is for the current service, patient, and has a booking
                if (slot.getAllocatedService().equals(service) && slot.getAllocatedPatient().equals(patient) && slot.isBooked()) {
                    System.out.println(patient.getName() + "\t\t" + slot.getTime() + "\t\t" + slot.isBooked());
                }
            }
        }
        System.out.println();
    }
}
        // Method to display all slots with their booking status
        public void displayAllSlotsWithBookingStatus() {
            System.out.println("All Slots with Booking Status:");
            System.out.println("Slot ID\tTime\tAvailable\tMaximum Slots\tSlots per Service");
            for (Slot slot : slots) {
                String bookingStatus = "Not Booked";
                if (slot.isBooked()==true) {
                    bookingStatus = "Booked";
                }
               System.out.println(slot.getId()+"\t"+slot.getTime()+"\t"+slot.isBooked()+"\t"+slot.allocatedService.getMaxSlots()+"\t"+slot.allocatedService.getPricePerSlot());
            }
        }
    
    public String reserveSlot(int slotid,int qid) {
        // Find an empty slot for the given service
		/* Slot emptySlot=null; */
        for (Slot slot : slots) {
            if (slot.getId()==slotid&&slot.getAllocatedPatient().getPid()==qid) {
               
                return "Slot for patient " + slot.getAllocatedPatient().getName() + " reserved successfully";
            }
          
        }
      

        // Check if there are no empty slots
        // Reserve the slot for the given patient

return null;
       
        
    }
   public void displayAllSlots() {
	   System.out.println("All Slots");
	   System.out.println("ID    Time      Date        Booked");
	   for(Slot slot:slots) {
		   System.out.println(slot.getId()+"    "+slot.getTime()+"   "+slot.getDate()+"   "+slot.isBooked());
	   } 
   }
   public void displayAllServices() {
	   System.out.println("All Services:");
	   System.out.println("Service ID\tService Name\t");
	   for (Service service : services) {
	   System.out.printf("%-20s%-20s\n", service.getID(), service.getTitle());
	   }
	   }
   public void displayAllPatients() {
	   System.out.println("All Patients");
	   System.out.println("Patient ID    Patient Name    Residency Type");
	   for(Patient patient:patients) {
		   System.out.println(patient.getPid()+"            "+patient.getName()+"           "+patient.getResidencyType());
	   } 
   }
    public void DataManagement() {
    	try {
    		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("actual.txt"));
    		for(Slot slot:slots) {
    			out.writeObject(slot);
    		}
    		out.close();
    		ObjectInputStream in=new ObjectInputStream(new FileInputStream("actual.txt"));
    		Slot obj=null;
    		while((obj=(Slot)in.readObject())!=null) {
    			System.out.println("Slot ID: "+obj.getId());
    			System.out.println("Slot Time: "+obj.getTime());
    			System.out.println("Is Slot Booked: "+obj.isBooked());
    			System.out.println("Patient ID: "+obj.getAllocatedPatient().getPid());
    			System.out.println("Patient Name: "+obj.getAllocatedPatient().getName());
    			System.out.println("Patient Residency Type: "+obj.getAllocatedPatient().getResidencyType());
    			System.out.println("Service ID: "+obj.getAllocatedService().getID());
    			System.out.println("Service Title: "+obj.getAllocatedService().getTitle());
    			System.out.println("Maximum Slots: "+obj.getAllocatedService().getMaxSlots());
    			System.out.println("Price per Slot: "+obj.getAllocatedService().getPricePerSlot());
    			System.out.println("Slot Date: "+obj.getDate());
    		}
    		in.close();
    		
    	}
    	catch(Exception e) {
    		
    	}
    	
    }

	/*
	 * public void displayAllServices() { for(Service s:services) {
	 * System.out.println(s.getTitle()+s) } }
	 */
    public String getServiceSchedule(String service) {
        // Collect all the slots for the given service
       ArrayList<Slot> serviceSlots = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot.getAllocatedService().getTitle().equalsIgnoreCase(service)) {
                serviceSlots.add(slot);
            }
        }

        // Sort the slots by date and time
        Collections.sort(serviceSlots, new Comparator<Slot>() {
            @Override
            public int compare(Slot slot1, Slot slot2) {
                int dateComparison = slot1.getDate().compareTo(slot2.getDate());
                if (dateComparison != 0) {
                    return dateComparison;
                } else {
                    return slot1.getTime().compareTo(slot2.getTime());
                }
            }
        });

        // Format the slots into a tabular-like string
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-20s %-20s\n", "Date", "Time", "Patient"));
        for (Slot slot : serviceSlots) {
            sb.append(String.format("%-20s %-20s %-20s\n", slot.getDate(), slot.getTime(), slot.getAllocatedPatient().getName()));
        }

        return sb.toString();
    }
}
