 package se.atg.entity.harrykart;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "powerUps")
@XmlType(propOrder = {"loop"})
public class PowerUps {
    private ArrayList<Loop> loop = new ArrayList<Loop>();

    public PowerUps() {}
	public PowerUps(ArrayList<Loop> loop) {
		super();
		this.loop = loop;
	}

	@XmlElement
	public ArrayList<Loop> getLoop() {
		return loop;
	}

	public void setLoops(ArrayList<Loop> loop) {
		this.loop = loop;
	}
	
	@Override
	public String toString() {
		return "PowerUps [loop=" + loop + "]";
	}
	
	
    
}
