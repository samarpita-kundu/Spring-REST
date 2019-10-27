package se.atg.entity.harrykart;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "participant")
@XmlType(propOrder = {"lane", "name", "baseSpeed"})
public class Participant implements Serializable{
	 private int lane;
     private String name;
     private int baseSpeed;
     
 	@XmlElement  
	public int getLane() {
		return lane;
	}
	public void setLane(int lane) {
		this.lane = lane;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public int getBaseSpeed() {
		return baseSpeed;
	}
	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}
	
	public Participant() {}
	
    public Participant(int lane, String name, int baseSpeed) {
        this.lane = lane;
        this.name = name;
        this.baseSpeed = baseSpeed;

    }
	@Override
	public String toString() {
		return "Participant [lane=" + lane + ", name=" + name + ", baseSpeed=" + baseSpeed + "]";
	}
    
    
}
