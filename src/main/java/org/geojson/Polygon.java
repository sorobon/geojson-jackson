package org.geojson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Polygon extends Geometry<List<Position>> {

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	Geometry<List<Position>> add(List<Position> elements) {
		return super.add(elements);
	}

	@JsonIgnore
	public List<Position> getExteriorRing() {
		assertExteriorRing();
		return coordinates.get(0);
	}

	void setExteriorRing(List<Position> points) {
		add(0, points);
	}

	@JsonIgnore
	public List<List<Position>> getInteriorRings() {
		assertExteriorRing();
		return coordinates.subList(1, coordinates.size());
	}

	List<Position> getInteriorRing(int index) {
		assertExteriorRing();
		return coordinates.get(1 + index);
	}

	Polygon addInteriorRing(List<Position> points) {
		assertExteriorRing();
		add(points);
		return this;
	}

	private void assertExteriorRing() {
		if (coordinates.isEmpty()) throw new RuntimeException("No exterior ring definied");
	}

	@Override
	public String toString() {
		return "Polygon{} " + super.toString();
	}
}
