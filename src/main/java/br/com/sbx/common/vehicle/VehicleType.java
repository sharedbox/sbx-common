package br.com.sbx.common.vehicle;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * 
 * @author Rafael Costi [rafaelcosti@outlook.com]
 * @version 1.0.0
 * @since 1.0.0
 */
public enum VehicleType {
	CAR(1),
	MOTORCYCLE(2),
	TRUCK(3);
	
	/**
	 * 
	 */
	private int vehicleType;
	
	/**
	 * 
	 * @param vehicleType
	 */
	private VehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer value() {
		return this.vehicleType;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Stream<VehicleType> stream() {
		return Arrays.asList(values()).stream();
	}
}
