package pageRank;

public class NodoError {
	
	private double pageRank;
	private int ID;
	
	public NodoError(int Id,double pR){
		this.ID = Id;
		this.pageRank = pR;
	}
	
	public void setPageRank(double pageRank) {
		this.pageRank = pageRank;
	}
	public double getPageRank() {
		return pageRank;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID() {
		return ID;
	}

}