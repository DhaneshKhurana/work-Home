package org.dhanesh.javabrains.dtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Car")
public class FourWheeler extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
