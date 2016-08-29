package org.geojson;

public class GeometryCollectionFactory {

    public static GeometryCollection create(GeoJsonObject ... geometries) {
        GeometryCollection geometryCollection = new GeometryCollection();
        if (geometries == null) return geometryCollection;
        for (GeoJsonObject geometry : geometries) {
            geometryCollection.add(geometry);
        }
        return geometryCollection;
    }

}
