package dto;

public class FileDTO {
	private int no;
	private String title;
	private String name;
	private String oNAME;
	private String sNAME;
	private String rdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getoNAME() {
		return oNAME;
	}
	public void setoNAME(String oNAME) {
		this.oNAME = oNAME;
	}
	public String getsNAME() {
		return sNAME;
	}
	public void setsNAME(String sNAME) {
		this.sNAME = sNAME;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "FileDTO [no=" + no + ", title=" + title + ", name=" + name + ", oNAME=" + oNAME + ", sNAME=" + sNAME
				+ ", rdate=" + rdate + "]";
	}
	
	
}
