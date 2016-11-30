package backend.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import backend.BaseEntity;

@Entity
@Table(name = "User")
@DiscriminatorValue("U")
public class User extends BaseEntity implements Comparable<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7865486010385573148L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id")
	// private Long id;
	//
	// public Long getId() {
	// return id;
	// }
	// public void setId(Long id) {
	// this.id = id;
	// }
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;

	@Column(name = "cnp")
	private String cnp;
	
	@Column(name= "city")
	private String city;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "bloodType")
	private String bloodType;

	public User() {
		this(null, null, null);
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String name, String age, String bloodType) {
		super();
		this.firstName = name;
		this.age = age;
		this.bloodType = bloodType;
	}

	public User(String firstName, String lastName, String age, String userName, String password, String phone,
			String address, String cnp, String city,String bloodType, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userName= userName;
		this.password=password;
		this.phone=phone;
		this.address=address;
		this.cnp=cnp;
		this.city=city;
		this.bloodType=bloodType;
		this.email=email;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fistName) {
		this.firstName = fistName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
