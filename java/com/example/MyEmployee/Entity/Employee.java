package com.example.MyEmployee.Entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

	@Entity
	@Table(name = "customer")
	public class Employee {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

		@Column(name = "firstname")
		private String firstname;

		@Column(name = "lastname")
		private String lastname;

		@Column(name = "fullname")
		private String fullname;
		
		@Column(name = "age")
		private int age;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "Gender")
		private String gender;
		
		@Column(name = "phone")
		private String phone;
		
		@Email
		@Column(name = "Email")
		private String email;
		
		@Column(name = "skill")
		private String skill;
		
		@Column(name = "description")
		private String description;
		public Employee() {
		}

		

		public Employee(String firstname, String lastname, String fullname, int age, String address, String gender, String phone, String email,
				String skill, String description) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.fullname = fullname;
			this.age = age;
			this.address = address;
			this.gender = gender;
			this.phone = phone;
			this.email = email;
			this.skill = skill;
			this.description = description;
		}

		public String getFullname() {
			return fullname;
		}



		public void setFullname(String fullname) {
			this.fullname = fullname;
		}



		public long getId() {
			return id;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getAge() {
			return this.age;
		}



		public String getFirstname() {
			return firstname;
		}



		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}



		public String getLastname() {
			return lastname;
		}



		public void setLastname(String lastname) {
			this.lastname = lastname;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public String getPhone() {
			return phone;
		}



		public void setPhone(String phone) {
			this.phone = phone;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setId(int id) {
			this.id = id;
		}



		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", fullname="
					+ fullname + ", age=" + age + ", address=" + address + ", gender=" + gender + ", phone=" + phone
					+ ", email=" + email + ", skill=" + skill + ", description=" + description + "]";
		}

		
}


