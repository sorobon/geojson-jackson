package org.geojson;

import java.util.List;

public class MultiLineString extends Geometry<List<Position>> {

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	Geometry<List<Position>> add(List<Position> elements) {
		return super.add(elements);
	}

	@Override
	public String toString() {
		return "MultiLineString{} " + super.toString();
	}
}
