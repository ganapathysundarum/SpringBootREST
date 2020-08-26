package com.external.api.consume.rest.model;

public class IfscBean {
	
	public String BANK;
	public String IFSC;
	public String BRANCH;
	public String ADDRESS;
	public String CONTACT;
	public String CITY;
	public String RTGS;
	public String DISTRICT;
	public String STATE;
	
	public String getBANK() {
		return BANK;
	}
	public void setBANK(String bANK) {
		BANK = bANK;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getRTGS() {
		return RTGS;
	}
	public void setRTGS(String rTGS) {
		RTGS = rTGS;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	
	@Override
	public String toString() {
		return "IfscBean [BANK=" + BANK + ", IFSC=" + IFSC + ", BRANCH=" + BRANCH + ", ADDRESS=" + ADDRESS
				+ ", CONTACT=" + CONTACT + ", CITY=" + CITY + ", RTGS=" + RTGS + ", DISTRICT=" + DISTRICT + ", STATE="
				+ STATE + "]";
	}
	
	

}
