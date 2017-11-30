package com.epam.lab.entity;

import java.sql.Date;

public class GradeBook {

	private Integer id;
	@Colum(name = "entry_date")
	private Date entryDate;
	private String group;
	private int course;

	public GradeBook(Date entryDate, String group, int course) {
		super();
		this.entryDate = entryDate;
		this.group = group;
		this.course = course;
	}

	public GradeBook(Integer id, Date entryDate, String group, int course) {
		super();
		this.id = id;
		this.entryDate = entryDate;
		this.group = group;
		this.course = course;
	}

	public GradeBook() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "EntryDate [id=" + id + ", entryDate=" + entryDate + ", group=" + group + ", course=" + course + "]";
	}
}
