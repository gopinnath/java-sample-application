package ind.gopinnath.javaexamples;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GeoExampleMain {

	public static void main(String[] args) throws Exception {
		String filename = "geodata.dat";
		URL resource = GeoExampleMain.class.getClassLoader().getResource(filename);
		if (resource == null) {
			throw new RuntimeException("Cannot load " + filename);
		}
		List<GeoData> dataPoints = Files.lines(Paths.get(resource.toURI())).map(Parser::parseGeoData).collect(Collectors.toList());
		dataPoints.forEach(System.out::println);
	}

}
