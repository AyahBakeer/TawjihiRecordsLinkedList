package application;

public class Nodee {
	public Nodee next;
	public Nodee Student;
	private int seatnumber;
	private String branch;
	private double average;

	public Nodee(int seatnumber, String branch, double average) {
		super();
		this.seatnumber = seatnumber;
		this.branch = branch;
		this.average = average;
	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
}
