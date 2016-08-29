package org.geojson;

import java.util.List;

public class MultiPolygonFactory {

    public static MultiPolygon create(List<Polygon> polygons) {
        MultiPolygon multiPolygon = new MultiPolygon();
        if (polygons == null) return multiPolygon;
        for (Polygon polygon : polygons) {
            multiPolygon.add(polygon);
        }
        return multiPolygon;
    }

}
