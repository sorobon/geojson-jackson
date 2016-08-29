package org.geojson;

import java.util.Properties;

public class FeatureFactory {

    public static Feature create(Properties properties) {
        Feature feature = new Feature();
        if (properties == null) return feature;
        for (String key : properties.stringPropertyNames()) {
            feature.addProperty(key, properties.get(key));
        }
        return  feature;
    }
}
