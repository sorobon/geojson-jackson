package org.geojson;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ToStringTest {

	@Test
	public void itShouldToStringCrs() throws Exception {
		assertEquals("Crs{type='name', properties=null}", new Crs().toString());
	}

	@Test
	public void itShouldToStringFeature() throws Exception {
		assertEquals("Feature{properties=null, geometry=null, id='null'}", new Feature().toString());
	}

	@Test
	public void itShouldToStringFeatureCollection() throws Exception {
		assertEquals("FeatureCollection{features=null}", new FeatureCollection().toString());
	}

	@Test
	public void itShouldToStringPoint() throws Exception {
		Point geometry = PointFactory.create(10, 20);
		assertEquals(
				"Point{coordinates=Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringPointWithAdditionalElements() {
		Point geometry = PointFactory.create(10, 20, 30, 40D, 50D);
		assertEquals(
				"Point{coordinates=Position{longitude=10.0, latitude=20.0, altitude=30.0, additionalElements=[40.0, 50.0]}} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringPointWithAdditionalElementsAndIgnoreNulls() {
		Point geometry = PointFactory.create(10, 20, 30, 40D, 50D);
		assertEquals(
				"Point{coordinates=Position{longitude=10.0, latitude=20.0, altitude=30.0, additionalElements=[40.0, 50.0]}} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringPolygon() throws Exception {
		Polygon geometry = PolygonFactory.create(PositionFactory.create(10, 20), PositionFactory.create(30, 40), PositionFactory.create(10, 40),
				PositionFactory.create(10, 20));
		assertEquals(
				"Polygon{} Geometry{coordinates=[[Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}, "
						+ "Position{longitude=30.0, latitude=40.0, altitude=null, additionalElements=null}, Position{longitude=10.0, latitude=40.0, altitude=null, additionalElements=null}, "
						+ "Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}]]} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringMultiPolygon() throws Exception {
		Polygon polygon = PolygonFactory.create(PositionFactory.create(10, 20), PositionFactory.create(30, 40),
				PositionFactory.create(10, 40), PositionFactory.create(10, 20));
		Polygon anotherPolygon = PolygonFactory.create(PositionFactory.create(5, 20), PositionFactory.create(30, 40), PositionFactory.create(10, 40), PositionFactory.create(5,
				20));
		MultiPolygon geometry = MultiPolygonFactory.create(polygon, anotherPolygon);
		assertEquals("MultiPolygon{} Geometry{coordinates=[[[Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=30.0, latitude=40.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=10.0, latitude=40.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}]], "
				+ "[[Position{longitude=5.0, latitude=20.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=30.0, latitude=40.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=10.0, latitude=40.0, altitude=null, additionalElements=null}, "
						+ "Position{longitude=5.0, latitude=20.0, altitude=null, additionalElements=null}]]]} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringLineString() throws Exception {
		LineString geometry = LineStringFactory.create(PositionFactory.create(49, 9), PositionFactory.create(41, 1));
		assertEquals("LineString{} MultiPoint{} Geometry{coordinates=["
				+ "Position{longitude=49.0, latitude=9.0, altitude=null, additionalElements=null}, "
						+ "Position{longitude=41.0, latitude=1.0, altitude=null, additionalElements=null}]} GeoJsonObject{}",
				geometry.toString());
	}

	@Test
	public void itShouldToStringMultiLineString() throws Exception {
		MultiLineString geometry = MultiLineStringFactory.create(Arrays.asList(PositionFactory.create(49, 9), PositionFactory.create(41, 1)));
		geometry.add(Arrays.asList(PositionFactory.create(10, 20), PositionFactory.create(30, 40)));
		assertEquals("MultiLineString{} Geometry{coordinates=[[Position{longitude=49.0, latitude=9.0, altitude=null, additionalElements=null}, "
				+ "Position{longitude=41.0, latitude=1.0, altitude=null, additionalElements=null}], "
				+ "[Position{longitude=10.0, latitude=20.0, altitude=null, additionalElements=null}, "
						+ "Position{longitude=30.0, latitude=40.0, altitude=null, additionalElements=null}]]} GeoJsonObject{}",
				geometry.toString());
	}
}
