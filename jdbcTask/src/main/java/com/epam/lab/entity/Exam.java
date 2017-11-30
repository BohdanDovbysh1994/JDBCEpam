package com.epam.lab.entity;

import java.sql.Date;

public class Exam {
	private Integer id;
	@Colum(name = "student_id")
	private Integer studentId;
	@Colum(name = "subject_id")
	private Integer subjectId;
	private Date date;
	private Integer mark;

	public Exam(Integer studentId, Integer subjectId, Date date, Integer mark) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.date = date;
		this.mark = mark;
	}

	public Exam(Integer id, Integer studentId, Integer subjectId, Date date, Integer mark) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.date = date;
		this.mark = mark;
	}

	public Exam() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", studentId=" + studentId + ", subjectId=" + subjectId + ", date=" + date + ", mark="
				+ mark + "]";
	}

}
