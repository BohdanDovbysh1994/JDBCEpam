package com.epam.lab.entity;

import java.sql.Date;

public class Student {
	private Integer id;
	@Colum(name = "first_name")
	private String firstName;
	@Colum(name = "last_name")
	private String lastName;
	private Date birthday;
	private String adress;
	private String phone;
	@Colum(name = "student_book_id")
	private Integer studenBookId;
	@Colum(name = "department_id")
	private Integer departmentId;

	public Student() {
		super();
	}

	public Student(Integer id, String firstName, String lastName, Date birthday, String adress, String phone,
			Integer studenBookId, Integer departmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.adress = adress;
		this.phone = phone;
		this.studenBookId = studenBookId;
		this.departmentId = departmentId;
	}

	public Student(String firstName, String lastName, Date birthday, String adress, String phone, Integer studenBookId,
			Integer departmentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.adress = adress;
		this.phone = phone;
		this.studenBookId = studenBookId;
		this.departmentId = departmentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStudenBookId() {
		return studenBookId;
	}

	public void setStudenBookId(Integer studenBookId) {
		this.studenBookId = studenBookId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", adress=" + adress + ", phone=" + phone + ", studenBookId=" + studenBookId + ", departmentId="
				+ departmentId + "]";
	}

}