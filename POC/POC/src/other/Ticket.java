package other;

import java.util.ArrayList;

public class Ticket {
	private String ticketNumber;
	private StringBuffer comments;
	private Employee createdBy;
	private ArrayList<Employee> assignedTo;
	private Customer belongsTo;
	private String Status;
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public StringBuffer getComments() {
		return comments;
	}
	public void setComments(StringBuffer comments) {
		this.comments = comments;
	}
	public Employee getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}
	public ArrayList<Employee> getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(ArrayList<Employee> assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Customer getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Customer belongsTo) {
		this.belongsTo = belongsTo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
