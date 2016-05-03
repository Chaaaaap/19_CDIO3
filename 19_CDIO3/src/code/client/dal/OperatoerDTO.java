package code.client.dal;

import code.client.dal.IOperatoerDAO.DALException;

public class OperatoerDTO {

	private int oprID;
	private String oprNavn;
	private String ini;
	private String cpr;
	private String password;
	private boolean active;
	private boolean inactive;
	private boolean loggedIn;
	private boolean admin;

	public OperatoerDTO(int oprID, String oprNavn, String ini, String cpr, String password, boolean admin) {
		this.oprID = oprID;
		this.oprNavn = oprNavn;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		active = true;
		inactive = false;
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public boolean inactive() {
		return inactive;
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

	public boolean setPassword(String password, String password2, String oldPassword)  throws DALException{
		int capitalLetter = 0;
		int smallLetter = 0;
		int number = 0;
		int passwordLength = 0;

		if(oldPassword.equals(this.password)) {
			if(password.equals(password2)) {
				if(password.length() >= 6) {
					for(int i = 0; i < password.length(); i++){
						if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
							capitalLetter = 1;
						}
						if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
							smallLetter = 1;
						}
						if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
							number = 1;
						}
					}
					if(capitalLetter+smallLetter+number+passwordLength >= 3) {
						this.password = password;
						return true;
					} else {
						throw new DALException("Passwordet skal indeholde minimum et stort tegn, et lille tegn og et tal.");
					}
				} else {
					throw new DALException("Passwordet skal minimum være 6 tegn langt.");
				}
			} else {
				throw new DALException("Dit nye password var ikke ens.");
			}
		} else {
			throw new DALException("Dit gamle password er ikke indtastet korrekt.");
		}
	}


	public boolean loggedIn() {
		return loggedIn;
	}

	public void logIn(boolean login) {
		this.loggedIn = login;
	}

	public boolean isAdmin() {
		return admin;
	}


}
