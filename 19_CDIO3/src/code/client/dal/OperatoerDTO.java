package code.client.dal;

public class OperatoerDTO {
	
	private int oprID;
	private String oprNavn;
	private String ini;
	private String cpr;
	private String password;
	private boolean active;
	private boolean loggedIn;
	
	public OperatoerDTO(int oprID, String oprNavn, String ini, String cpr, String password) {
		this.oprID = oprID;
		this.oprNavn = oprNavn;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

	public void deactivate() {
		active = false;
	}
	public int getOprID() {
		return oprID;
	}

	public void setOprID(int oprID) {
		this.oprID = oprID;
	}

	public String getOprNavn() {
		return oprNavn;
	}

	public void setOprNavn(String oprNavn) {
		this.oprNavn = oprNavn;
	}

	public String getIni() {
		return ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean loggedIn() {
		return loggedIn;
	}
	
	public void logIn() {
		this.loggedIn = true;
	}

	
}
