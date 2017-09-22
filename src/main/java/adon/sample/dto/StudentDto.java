package adon.sample.dto;

import adon.sample.domain.Student;

public class StudentDto extends AbstractBaseDto {

	private static final long serialVersionUID = -402288370379800832L;

	private String firstName;

	private String lastName;

	private Integer age;

	private String address;
	
	public StudentDto() {
	}

	public StudentDto(Student student) {
		this.uuid = student.getUuid();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.age = student.getAge();
		this.address = student.getAddress();
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
