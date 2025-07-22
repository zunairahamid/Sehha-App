package sehha;
import java.io.Serializable;
public class Patient implements Serializable{
	public int pid;
	public String name;
	public String residencyType;
	public enum ResidencyType{
		VISITOR,
		RESIDENT
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidencyType() {
		return residencyType;
	}
	public void setResidencyType(String residencyType) {
		this.residencyType = residencyType;
	}
	public ResidencyType residencytype;
	public ResidencyType getResidencytype() {
		return residencytype;
	}
	public void setResidencytype(ResidencyType residencytype) {
		this.residencytype = residencytype;
	}
	public Patient(int pid, String name, String residencyType ) {
		super();
		this.pid = pid;
		this.name = name;
		this.residencyType = residencyType;
		
	}
	
	

}
