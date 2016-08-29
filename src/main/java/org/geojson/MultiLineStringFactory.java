package org.geojson;

import java.util.List;

public class MultiLineStringFactory {

    public static MultiLineString create(List<Position> ... strings) {
        MultiLineString multiLineString = new MultiLineString();
        if (strings == null) return multiLineString;
        for (List<Position> string : strings) {
            multiLineString.add(string);
        }

        return multiLineString;
    }

}
