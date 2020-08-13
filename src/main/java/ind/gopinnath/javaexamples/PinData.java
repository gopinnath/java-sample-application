package ind.gopinnath.javaexamples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PinData {

	private String country;
	
	private String pincode;
	
	private String locality;
	
	private String state;
	
	private String province;
	
	private String community;
	
	private Double latitude;
	
	private Double longitude;
}
