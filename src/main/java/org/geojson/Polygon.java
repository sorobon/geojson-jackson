package org.geojson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.List;

public class Polygon extends Geometry<List<Position>> {

	public Polygon() {
	}

	public Polygon(List<Position> polygon) {
		add(polygon);
	}

	public Polygon(Position... polygon) {
		add(Arrays.asList(polygon));
	}

	public void setExteriorRing(List<Position> points) {
		add(0, points);
	}

	@JsonIgnore
	public List<Position> getExteriorRing() {
		assertExteriorRing();
		return coordinates.get(0);
	}

	@JsonIgnore
	public List<List<Position>> getInteriorRings() {
		assertExteriorRing();
		return coordinates.subList(1, coordinates.size());
	}

	public List<Position> getInteriorRing(int index) {
		assertExteriorRing();
		return coordinates.get(1 + index);
	}

	public Polygon addInteriorRing(List<Position> points) {
		assertExteriorRing();
		add(points);
		return this;
	}

	public void addInteriorRing(Position... points) {
		assertExteriorRing();
		add(Arrays.asList(points));
	}

	private void assertExteriorRing() {
		if (coordinates.isEmpty())
			throw new RuntimeException("No exterior ring definied");
	}

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	@Override
	public String toString() {
		return "Polygon{} " + super.toString();
	}
}
