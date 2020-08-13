package ind.gopinnath.javaexamples;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GeoData {

	private Integer geonameid;
	
	private String name;
	
	private Double latitude;
	
	private Double longitude;
	
	private String country;
	
	private String timezone;
	
	private Date modificationDate;
}
