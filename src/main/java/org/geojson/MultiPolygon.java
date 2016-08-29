package org.geojson;

import java.util.List;

public class MultiPolygon extends Geometry<List<List<Position>>> {

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	MultiPolygon add(Polygon polygon) {
		add(polygon.coordinates);
		return this;
	}

	@Override
	public String toString() {
		return "MultiPolygon{} " + super.toString();
	}
}
