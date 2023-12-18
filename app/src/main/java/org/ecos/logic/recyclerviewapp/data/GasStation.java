package org.ecos.logic.recyclerviewapp.data;

import java.io.Serializable;

public class GasStation implements Serializable{
	private int gasStationId;
	private String name;
	private String address;
	private String location;
	private double longitude;
	private double latitude;
	private int logo;
	public GasStation(int gasStationId, String name, String address, String location, double longitude, double latitude,
					  int logo) {
		
		this.gasStationId = gasStationId;
		this.name = name;
		this.address = address;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.logo = logo;
	}
	public int getGasStationId() {
		return gasStationId;
	}
	public void setGasStationId(int gasStationId) {
		this.gasStationId = gasStationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getLogo() {
		return logo;
	}
	public void setLogo(int logo) {
		this.logo = logo;
	}

}
