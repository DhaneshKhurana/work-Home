package org.dhanesh.javabrains.dtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Bike")
public class TwoWheeler extends Vehicle {
	
	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	private String steeringHandle;
}
