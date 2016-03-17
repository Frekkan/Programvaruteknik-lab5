package workshop;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ofk14den
 * @author Jonas Oster
 */
public class CsvToMapParser {

	private String csv;

	/**
	 * Constructor for the CsvToMapParser class
	 * 
	 * @param CsvString
	 *            String
	 */
	public CsvToMapParser(String CsvString) {

		csv = CsvString;
	}

	/**
	 * Create a Map from the given Csv
	 * 
	 * @return Map<LocalDate, Double>
	 */
	public Map<LocalDate, Double> getResult() {

		String[] commaSplit;
		Map<LocalDate, Double> value = new HashMap<LocalDate, Double>();
		commaSplit = csv.split(";");

		for (int i = 0; i < commaSplit.length; i++) {
			if (commaSplit[i].startsWith("Y")) {
				value.put(LocalDate.parse(commaSplit[i - 2]),
						Double.parseDouble(commaSplit[i - 1]));
			}
		}

		return value;
	}

}
