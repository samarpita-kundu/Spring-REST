package se.atg.entity.harrykart;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lane {
	@XmlAttribute
	private int number;
	@XmlValue
	private int powerUpVal;
	@Override
	public String toString() {
		return "Lane [number=" + number + ", powerUpVal=" + powerUpVal + "]";
	}
	
	public Lane() {}
	
	public Lane(int number, int powerUpVal) {
		super();
		this.number = number;
		this.powerUpVal = powerUpVal;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPowerUpVal() {
		return powerUpVal;
	}

	public void setPowerUpVal(int powerUpVal) {
		this.powerUpVal = powerUpVal;
	}
	
	
}
