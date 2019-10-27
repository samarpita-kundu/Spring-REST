package se.atg.entity.harrykart;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "loop")
@XmlType(propOrder = {"lane"})
public class Loop implements Serializable{
	
	private ArrayList<Lane> lane = new ArrayList<Lane>();	
//	@XmlAttribute(name = "number")
//	private int number;
	
	@XmlElement
	public ArrayList<Lane> getLane() {
		return lane;
	}

	public void setLane(ArrayList<Lane> lane) {
		this.lane = lane;
	}
	
	
//	public int getNumber() {
//		return number;
//	}
//
//	public void setNumber(int number) {
//		this.number = number;
//	}

	public Loop() {}
	
	public Loop(ArrayList<Lane> lane) {
		super();
		this.lane = lane;
	}

	@Override
	public String toString() {
		return "Loop [lane=" + lane + "]";
	}

	
	
	
}
