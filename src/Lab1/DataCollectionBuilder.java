package Lab1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class build a collection of data.
 * 
 * @author Jonas Oster
 * @author Rashed Davodi
 * @author Jonatan Hogberg
 * @version 17/02 - 2016
 */

public class DataCollectionBuilder {

	private DataSource xData;
	private DataSource yData;
	private Resolution resolution;
	private Map<String, MatchedDataPair> finalResult;

	/**
	 * This constructor defines data source 1, data source 2
	 * and the resolution. It also creates a hashmap where the
	 * final result will be placed
	 */
	public DataCollectionBuilder(DataSource xData, DataSource yData, Resolution resolution){
		this.resolution = resolution;
		this.xData = xData;
		this.yData = yData;
		finalResult = new HashMap<String, MatchedDataPair>();
	}

	/**
	 * This method fetches the title of the collection
	 */
	public String getTitle(){	
		return "Title: " + xData.getName() + ", " + yData.getName();
	}

	/**
	 * This method sets the resolution of the collection
	 */
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	/**
	 * This method fetches the resolution of the collection
	 */
	public Resolution getResolution() {
		return resolution;
	}

	/**
	 * This method shows the result by calculating the average value from the pairs
	 */
	public DataCollection getResult(){
		Map<String, List <MatchedDataPair>> MatchedXY = searchMatchedPair();

		for(Entry<String, List<MatchedDataPair>> pairs : MatchedXY.entrySet()){
			List <MatchedDataPair> list = pairs.getValue();
			double sumX = 0.0;
			double sumY = 0.0;
			int counter = 0;


			for (MatchedDataPair pair : list) {
				sumX = sumX + pair.getXvalue();
				sumY = sumY + pair.getYvalue();
				counter++;
				
			}

			finalResult.put(pairs.getKey(), new MatchedDataPair((sumX / counter), (sumY / counter)));
		}
	
		return new DataCollection(getTitle(), xData.getName()+": " + xData.getUnit(),
				yData.getName()+": "+yData.getUnit(), finalResult);
	}

	/**
	 * This method search after matching data pairs. A matching pair is found 
	 * when they have an equal key. The key is the date. 
	 */
	private Map<String, List <MatchedDataPair>> searchMatchedPair(){

		Map<String, List <MatchedDataPair>> MatchedXY = new HashMap<String, List <MatchedDataPair>>() ;	

		for(Entry<LocalDate, Double> x: xData.getData().entrySet()){
			for(Entry<LocalDate, Double> y: yData.getData().entrySet()){
				if(resolution.createLabel(x.getKey()).equals(resolution.createLabel(y.getKey()))){	
					if(MatchedXY.get(resolution.createLabel(x.getKey())) != null){
						List<MatchedDataPair> matchedPair = MatchedXY.get(resolution.createLabel(x.getKey()));
						matchedPair.add(new MatchedDataPair(x.getValue(), y.getValue()));
					} else {
						List<MatchedDataPair> matchedPair = new ArrayList<MatchedDataPair>();
						matchedPair.add(new MatchedDataPair(x.getValue(), y.getValue()));
						MatchedXY.put(resolution.createLabel(x.getKey()), matchedPair);
					}
				}
			}
		}
		return MatchedXY;
	}
}
