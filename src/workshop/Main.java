package workshop;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Lab1.DataCollection;
import Lab1.DataCollectionBuilder;
import Lab1.ImplDataSource;
import Lab1.Resolution;

/**
 * @author ofk14den
 * @author Jonas Oster
 */
public class Main {
	private static DataCollectionBuilder dcb;
	private static Map<LocalDate, Double> temperaturDataMap = new HashMap<LocalDate, Double>();
	private static Map<LocalDate, Double> goalDataMap = new HashMap<LocalDate, Double>();

	public static void main(String[] args) {
		TemperatureSource temperatur = new TemperatureSource();
		FootballGoalsSource goal = new FootballGoalsSource("Strömvallen");
		ImplDataSource dataX = new ImplDataSource("Temerature", "C");
		ImplDataSource dataY = new ImplDataSource("Goal", "z+");
		dcb = new DataCollectionBuilder(dataX, dataY, Resolution.DAY);
		DataCollection dc;

		temperaturDataMap = temperatur.getData();
		goalDataMap = goal.getData();

		for (LocalDate temperaturKey : temperaturDataMap.keySet()) {
			dataX.addData(temperaturKey, temperaturDataMap.get(temperaturKey));

		}
		for (LocalDate goalKey : goalDataMap.keySet()) {
			dataY.addData(goalKey, goalDataMap.get(goalKey));
		}

		System.out.println(dc = dcb.getResult());
	

	}

}
