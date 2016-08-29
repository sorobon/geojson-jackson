package org.geojson;

import java.util.Arrays;
import java.util.List;

public class MultiPointFactory {

    public static MultiPoint create(List<Position> coordinates) {
        MultiPoint multiPoint = new MultiPoint();
        if (coordinates == null) return multiPoint;
        for (Position coordinate : coordinates) {
            multiPoint.add(coordinate);
        }

        return multiPoint;
    }

    public static MultiPoint create(Position ... coordinates) {
        return create(Arrays.asList(coordinates));
    }
}
