package codingwithscpark;

import org.json.simple.parser.JSONParser;

public class BoxInteger {
	private Integer value;
	JSONParser jsonparser = new JSONParser();
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
