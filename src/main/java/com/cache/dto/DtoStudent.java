package com.cache.dto;

import com.cache.model.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DtoStudent {

	private Integer studentId;
	private Integer collegeId;
	private String name;
	private String email;
	private String city;
	private String state;
	private String street;
	private String zipCode;
	
	public DtoStudent() {}
	
	public DtoStudent(Integer studentId, Integer collegeId, String name, String email, String city, String state,
			String street, String zipCode) {
		super();
		this.studentId = studentId;
		this.collegeId = collegeId;
		this.name = name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.street = street;
		this.zipCode = zipCode;
	}


	public Integer getStudentId() {
		return studentId;
	}



	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}



	public Integer getCollegeId() {
		return collegeId;
	}



	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	public Student mapDtoStudentToEntity(DtoStudent dtoStudent) {
		Student student = new Student();
		student.setId(dtoStudent.getStudentId());
		student.setCollegeId(dtoStudent.getCollegeId());
		student.setEmail(dtoStudent.getEmail());
		student.setName(dtoStudent.getName());
		student.setCity(dtoStudent.getCity());
		student.setState(dtoStudent.getState());
		student.setStreet(dtoStudent.getStreet());
		student.setZipCode(dtoStudent.getZipCode());
		return student;
		}
	
	public DtoStudent(Student student) {
		this.studentId = student.getId();
		this.collegeId = student.getCollegeId();
		this.email = student.getEmail();
		this.name = student.getName();
		this.city = student.getCity();
		this.state = student.getState();
		this.street = student.getStreet();
		this.zipCode = student.getZipCode();
	}
	
	public DtoStudent mapEntityToDtoStudent(Student student) {
		DtoStudent dtoStudent = new DtoStudent();
		dtoStudent.setStudentId(student.getId());
		dtoStudent.setCollegeId(student.getCollegeId());
		dtoStudent.setEmail(student.getEmail());
		dtoStudent.setName(student.getName());
		dtoStudent.setCity(student.getCity());
		dtoStudent.setState(student.getState());
		dtoStudent.setStreet(student.getStreet());
		dtoStudent.setZipCode(student.getZipCode());
		return dtoStudent;
	}
}
