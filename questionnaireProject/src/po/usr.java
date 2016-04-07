package po;

public class usr {
	private String UsrID;
	private String Pwd;
	private String Identity;
	private String IDStatus;
	public usr(){}
	public usr(String a,String b)
	{
		UsrID=a;
		Pwd=b;
	}
	public String getUsrID() {
		return UsrID;
	}
	public void setUsrID(String usrID) {
		UsrID = usrID;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getIdentity() {
		return Identity;
	}
	public void setIdentity(String identity) {
		Identity = identity;
	}
	public String getIDStatus() {
		return IDStatus;
	}
	public void setIDStatus(String iDStatus) {
		IDStatus = iDStatus;
	}
	
	

}
