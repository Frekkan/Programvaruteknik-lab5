package workshop;

import java.time.LocalDate;
import java.util.Map;

import Lab1.DataSource;

/**
 * @author ofk14den
 * @author Jonas Oster
 */
public class TemperatureSource implements DataSource {
	private String name;
	private String unit;
	
	/**
	 * Name value is where the temprature is taken
	 * @param name
	 * @param unit
	 */
	public TemperatureSource(String name, String unit) {
		this.name = name;
		this.unit = unit;
	}

	/**
	 * Sets default values
	 */
	public TemperatureSource() {
		name = "Gävle";
		unit = "C";
	}

	@Override
	public String getName() {
		return "Temperatur for " + name;
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher csvFetcher = new UrlFetcher(
				"http://opendata-download-metobs.smhi.se/explore/zip?parameterIds=2&stationId=107420&period=corrected-archive&includeMetadata=false");
		CsvToMapParser parsed = new CsvToMapParser(csvFetcher.getContent());
		Map<LocalDate, Double> data = parsed.getResult();

		return data;
	}

}
