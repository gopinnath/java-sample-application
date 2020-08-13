package ind.gopinnath.javaexamples;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class Parser {
	
	static final Integer[] geoColumnsOfInterest = new Integer[] {0,1,4,5,8,17,18};
	
	static final Integer[] pinColumnsOfInterest = new Integer[] {0,1,2,3,5,7,9,10};
	
	static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	static final Function<String,Integer> parseInt = value -> (value == null || "".equals(value))?null:Integer.valueOf(value);
	
	static final Function<String,Double> parseDouble = value -> (value == null || "".equals(value))?null:Double.valueOf(value);
	
	static final Function<String,String> parseString = value -> (value == null || "".equals(value))?null:value;
	
	static final Function<String,Date> parseDate = SafeFunction.safe(dateFormat::parse);
	
	static final GeoData parseGeoData(String tsvString)	{
		String geoData[] = tsvString.split("\t");
		GeoData data = new GeoData(parseInt.apply(geoData[geoColumnsOfInterest[0]]),
				parseString.apply(geoData[geoColumnsOfInterest[1]]),
				parseDouble.apply(geoData[geoColumnsOfInterest[2]]),
				parseDouble.apply(geoData[geoColumnsOfInterest[3]]),
				parseString.apply(geoData[geoColumnsOfInterest[4]]),
				parseString.apply(geoData[geoColumnsOfInterest[5]]),
				parseDate.apply(geoData[geoColumnsOfInterest[6]]));
		
		return data;
	}
	
	static final PinData parsePinData(String csvString)	{
		String geoData[] = csvString.split(",");
		PinData data = new PinData(parseString.apply(geoData[pinColumnsOfInterest[0]]),
				parseString.apply(geoData[pinColumnsOfInterest[1]]),
				parseString.apply(geoData[pinColumnsOfInterest[2]]),
				parseString.apply(geoData[pinColumnsOfInterest[3]]),
				parseString.apply(geoData[pinColumnsOfInterest[4]]),
				parseString.apply(geoData[pinColumnsOfInterest[5]]),
				parseDouble.apply(geoData[pinColumnsOfInterest[6]]),
				parseDouble.apply(geoData[pinColumnsOfInterest[7]]));
		
		return data;
	}
}
