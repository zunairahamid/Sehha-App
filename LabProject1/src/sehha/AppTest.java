package sehha;
import java.time.LocalDate;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.Serializable;
public class AppTest implements Serializable {
	public static void main(String[] args) {
		AdminApp ap1=new AdminApp();
		    Patient p1=new Patient(1,"Zunaira Hamid","Resident");
		    Patient p2=new Patient(2,"Hafsa Hamid","Resident");
		    Patient p3=new Patient(3,"Hanzala Hamid","Resident");
		    Patient p4=new Patient(4,"Ikrama Hamid", "Resident");
		    Patient p5=new Patient(5,"Tayyaba Awais","Resident");
		 Service s1=new Service("Dentist Appointment",4,3,2);
		 Service s2=new Service("Mental Health Counselling",5,4,3);
		 Service s3=new Service("Family Planning",6,7,5);
		 Service s4=new Service("Daily Checkup",8,9,1);
		 Service s5=new Service("Pharmacy Training",2,3,4);
		 Slot slot1=new Slot(1,"03:05:04",LocalDate.parse("2023-05-10"),true,s1,p1);
		 Slot slot2=new Slot(2,"04:07:09",LocalDate.parse("2023-09-07"),false,s2,p2);
		 Slot slot3=new Slot(3,"05:08:07",LocalDate.parse("2023-10-07"),true,s3,p3);
		 Slot slot4=new Slot(4,"02:05:10",LocalDate.parse("2023-08-07"),false,s4,p4);
		 Slot slot5=new Slot(5,"09:10:05",LocalDate.parse("2023-11-09"),true,s5,p5);
		 ap1.addPatient(p1);
		 ap1.addPatient(p2);
		 ap1.addPatient(p3);
		 ap1.addPatient(p4);
		 ap1.addPatient(p5);
		 ap1.addService(s1);
		 ap1.addService(s2);
		 ap1.addService(s3);
		 ap1.addService(s4);
		 ap1.addService(s5);
		 ap1.addSlot(slot1);
		 ap1.addSlot(slot2);
		 ap1.addSlot(slot3);
		 ap1.addSlot(slot4);
		 ap1.addSlot(slot5);
		System.out.println(ap1.getServiceSchedule("Mental Health Counselling"));
	}

}
