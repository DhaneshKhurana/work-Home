package org.dhanesh.javabrains.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="VehicleType",
		discriminatorType=DiscriminatorType.STRING
)
public class Vehicle {
	
	@Id
	private int vehicleId;
	private String type;
	private String registrationNumber;
	
	@ManyToMany(mappedBy="vehicles")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<UserDetails> user = new ArrayList<>();
	
	
	
	public List<UserDetails> getUser() {
		return user;
	}
	public void setUser(List<UserDetails> user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}
