package coding.mentor.entity;
import java.util.Date;


public class Order {
	 private int id;
	 private int accountId;
	 private Date date;
	 private boolean isApproved;
	 
	 
	 public Order () {
		 
	 }
	 
	 

	 
	public Order(int accountId, boolean isApproved) {
		super();
		this.accountId = accountId;
		this.isApproved = isApproved;
	}




	public Order(int id, int accountId, Date date, boolean isApproved) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.date = date;
		this.isApproved = isApproved;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	 
	 
	 
	 
	 
	 
	 
}
