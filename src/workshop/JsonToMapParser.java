package workshop;

import java.util.Map;

import com.owlike.genson.Genson;

/**
 *
 * @author thomas
 */
public class JsonToMapParser {

	private final String json;

	public JsonToMapParser(String json) {
		this.json = json;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResult() {
		return new Genson().deserialize(json, Map.class);
	}
}
