package org.geojson;

public class FeatureCollectionFactory {

    public static FeatureCollection create(Feature ... features) {
        FeatureCollection featureCollection = new FeatureCollection();
        if (features == null) return featureCollection;
        for (Feature feature : features) {
            featureCollection.add(feature);
        }
        return featureCollection;
    }

}
