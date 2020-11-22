package controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CoordinateGenerator {
	
	private double latitude;
	private double longitude;
	private int quantity;
	private List<Double> coordenates = new ArrayList<>();

	private static final int COORD_X = 180;
	private static final int COORD_Y = 90;

	public CoordinateGenerator(int quantity) {
		setQuantity(quantity);
	}

	private double generateRandomCoordinate(int n) {
		double coordinate = Math.random()*((n + n)) - n;
		BigDecimal bd = BigDecimal.valueOf(coordinate).setScale(6, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}

	public void generateCoordinates() {
		int i = 0;
		while (i <= getQuantity()) {
			setLatitude(generateRandomCoordinate(COORD_Y));
			setLongitude(generateRandomCoordinate(COORD_X));
			setCoordenates(getLatitude());
			setCoordenates(getLongitude());
			i++;
		}
	}
	
	// Possível Alteração no método coordinateFormat, para deixar o Output mais intuitivo 
	public static String coordinateFormat(double latitude, double longitude) {
		return String.valueOf(latitude + ", " + longitude);
	}

	public List<Double> getCoordenates() {
		return coordenates;
	}

	public void setCoordenates(double coordenates) {
		this.coordenates.add(coordenates);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
