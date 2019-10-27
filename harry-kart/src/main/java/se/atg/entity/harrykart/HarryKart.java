package se.atg.entity.harrykart;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "harryKart")
@XmlType(propOrder = {"numberOfLoops", "startList", "powerUps"})
public class HarryKart {
	private int numberOfLoops;
    private StartList startList ;
    private PowerUps powerUps;
    
    public HarryKart() {}
	public HarryKart(int numberOfLoops, StartList startList, PowerUps powerUps) {
		super();
		this.numberOfLoops = numberOfLoops;
		this.startList = startList;
		this.powerUps = powerUps;
	}

	@XmlElement
	public int getNumberOfLoops() {
		return numberOfLoops;
	}

	public void setNumberOfLoops(int numberOfLoops) {
		this.numberOfLoops = numberOfLoops;
	}
	
	@XmlElement
	public StartList getStartList() {
		return startList;
	}

	public void setStartList(StartList startList) {
		this.startList = startList;
	}

	@XmlElement
	public PowerUps getPowerUps() {
		return powerUps;
	}

	public void setPowerUps(PowerUps powerUps) {
		this.powerUps = powerUps;
	}
	@Override
	public String toString() {
		return "HarryKart [numberOfLoops=" + numberOfLoops + ", startList=" + startList + ", powerUps=" + powerUps
				+ "]";
	}
	
	
}
