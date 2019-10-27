package se.atg.entity.harrykart;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "startList")
@XmlType(propOrder = {"participant"})
public class StartList {
    private ArrayList<Participant> participant = new ArrayList<Participant>();

    public StartList() {}
	public StartList(ArrayList<Participant> participant) {
		super();
		participant = participant;
	}

	@XmlElement 
	public ArrayList<Participant> getParticipant() {
		return participant;
	}

	public void setParticipant(ArrayList<Participant> participant) {
		participant = participant;
	}
	@Override
	public String toString() {
		return "StartList [participant=" + participant + "]";
	}
	
	
    
}
