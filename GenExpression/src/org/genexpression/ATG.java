package org.genexpression;

public class ATG {
	private String ATGnr;
	private String ATnr;
	private String Pfam;

	public ATG(String atnr, String atgnr) {
		setATnr(atnr);
		setATGnr(atgnr);
		setPfam("");
	}

	public ATG(String atnr, String atgnr, String protein) {
		setATnr(atnr);
		setATGnr(atgnr);
		setPfam(protein);
	}

	public String getATGnr() {
		return ATGnr;
	}

	public String getATnr() {
		return ATnr;
	}

	public String getPfam() {
		return Pfam;
	}

	public void setATGnr(String ATGid) {
		ATGnr = ATGid;
	}

	public void setATnr(String ATid) {
		ATnr = ATid;
	}

	public void setPfam(String protein) {
		Pfam = protein;
	}

}
