package org.geojson;

import java.util.List;

public class PolygonFactory {

    public static Polygon create(List<List<Position>> coordinates) {
        Polygon polygon = new Polygon();
        if (coordinates == null) return polygon;
        for (List<Position> coordinate : coordinates) {
            polygon.add(coordinate);
        }
        return polygon;
    }

    public static Polygon create(LineString outer, List<LineString> inner) {
        Polygon polygon = create(outer);
        if (inner == null) return polygon;
        for (LineString lineString : inner) {
            polygon.addInteriorRing(lineString.coordinates);
        }

        return polygon;
    }

    public static Polygon create(LineString outer) {
        Polygon polygon = new Polygon();
        if (outer == null) return polygon;
        polygon.setExteriorRing(outer.coordinates);
        return polygon;
    }
}
