package nl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mzwart on 10-1-2017.
 */
@Entity
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	private String name;
	private String dateStarted; //Automatically started upon creation
	private String dateFinished;
	private boolean finished;
	private int daysPassed;
	private long ctoUser;
	private int totalMoneySpent;
	private boolean privateProfile = false;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProjectMessages> projectMessages;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProjectTodo> projectTodo;

	private int estimatedTime;
	private int estimatedCost;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}

	public String getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(String dateFinished) {
		this.dateFinished = dateFinished;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public int getDaysPassed() {
		return daysPassed;
	}

	public void setDaysPassed(int daysPassed) {
		this.daysPassed = daysPassed;
	}

	public long getCtoUser() {
		return ctoUser;
	}

	public void setCtoUser(long ctoUser) {
		this.ctoUser = ctoUser;
	}

	public int getTotalMoneySpent() {
		return totalMoneySpent;
	}

	public void setTotalMoneySpent(int totalMoneySpent) {
		this.totalMoneySpent = totalMoneySpent;
	}

	public boolean isPrivateProfile() {
		return privateProfile;
	}

	public void setPrivateProfile(boolean privateProfile) {
		this.privateProfile = privateProfile;
	}

	public int getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public List<ProjectMessages> getProjectMessages() {
		return projectMessages;
	}

	public void setProjectMessages(List<ProjectMessages> projectMessages) {
		this.projectMessages = projectMessages;
	}

	public List<ProjectTodo> getProjectTodo() {
		return projectTodo;
	}

	public void setProjectTodo(List<ProjectTodo> projectTodo) {
		this.projectTodo = projectTodo;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
}
