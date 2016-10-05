package org.dhanesh.javabrains.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="Clinet_Details")
public class UserDetails {
	@Id
	@Column(name="Id")
	private long userId;
	
	@Column(name="FName")
	private String userName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="home_street")),
		@AttributeOverride(name="state", column=@Column(name="home_state")),
		@AttributeOverride(name="city", column=@Column(name="home_city")),
		@AttributeOverride(name="pincode", column=@Column(name="home_pin"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="office_street")),
		@AttributeOverride(name="state", column=@Column(name="office_state")),
		@AttributeOverride(name="city", column=@Column(name="office_city")),
		@AttributeOverride(name="pincode", column=@Column(name="office_pin"))
	})
	private Address officeAddress;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable( name="Books", joinColumns=@JoinColumn(name="User_Id") )
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId( columns= {@Column(name="Book_ID")}, generator="hilo-gen", type=@Type(type="Long") )
	private List<Book> rentedBooks = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="UserToVehicle", 
				joinColumns = @JoinColumn(name="User_ID"), 
				inverseJoinColumns = @JoinColumn(name="Vehicle_ID"))
	private List<Vehicle> vehicles = new ArrayList<>();
	
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<Book> getRentedBooks() {
		return rentedBooks;
	}
	public void setRentedBooks(List<Book> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
