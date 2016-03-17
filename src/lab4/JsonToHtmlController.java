package lab4;

import com.owlike.genson.Genson;

import Lab1.DataCollectionBuilder;
import Lab1.DataSource;
import Lab1.Resolution;
import workshop.FootballGoalsSource;
import workshop.TemperatureSource;

/**
 * Controller of data to JsonToHtml class
 */
public class JsonToHtmlController {
	private DataSource footballGoals;
	private DataSource temperature;
	private DataCollectionBuilder dataCollectionBuilder;

	/**
	 * Json string from data
	 * @return
	 */
	public String getJsonString() {
		footballGoals = new FootballGoalsSource("Strömvallen");
		temperature = new TemperatureSource();
		footballGoals.getData();
		temperature.getData();
		dataCollectionBuilder = new DataCollectionBuilder(footballGoals, temperature, Resolution.DAY);
		
		String jsonString = new Genson().serialize(dataCollectionBuilder.getResult());
		
		return jsonString;
	}	
}
