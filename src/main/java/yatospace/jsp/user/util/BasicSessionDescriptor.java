package yatospace.jsp.user.util;

/**
 * Basic implementation of session descriptor. 
 * @author MV
 * @version 1.0
 */
public class BasicSessionDescriptor implements SessionDescriptor{
	private String generalId = ""; 
	private String localId  = ""; 
	private String localSessionNotes = "";
	private String generalSessionNotes = ""; 
	
	@Override
	public String generalId() {
		return generalId;
	}

	@Override
	public String localId() {
		return localId;
	}

	@Override
	public String localSessionNotes() {
		return localSessionNotes;
	}

	@Override
	public String generalSessionNotes() {
		return generalSessionNotes;
	}

	public String getGeneralId() {
		return generalId;
	}

	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		if(localId==null) localId = ""; 
		this.localId = localId;
	}

	public String getLocalSessionNotes() {
		return localSessionNotes;
	}

	public void setLocalSessionNotes(String localSessionNotes) {
		if(localSessionNotes==null) localSessionNotes = ""; 
		this.localSessionNotes = localSessionNotes;
	}

	public String getGeneralSessionNotes() {
		return generalSessionNotes;
	}

	public void setGeneralSessionNotes(String generalSessionNotes) {
		if(generalSessionNotes==null) generalSessionNotes = ""; 
		this.generalSessionNotes = generalSessionNotes;
	}
}
