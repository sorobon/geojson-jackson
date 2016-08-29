package org.geojson;

import java.util.Arrays;
import java.util.List;

public class LineStringFactory {

    public static LineString create(List<Position> coordinates) {
        LineString lineString = new LineString();
        if (coordinates == null) return lineString;
        for (Position coordinate : coordinates) {
            lineString.add(coordinate);
        }

        return lineString;
    }

    public static LineString create(Position ... coordinates) {
        return create(Arrays.asList(coordinates));
    }
}
