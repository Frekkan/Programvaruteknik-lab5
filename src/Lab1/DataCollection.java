package Lab1;
import java.util.Map;

/**
 * This class holds the actual collection of data
 * that the class DataCollectionBuilder has built 
 * 
 * @author Jonas Oster
 * @author Rashed Davodi
 * @author Jonatan Hogberg
 * @version 17/02 - 2016
 */

public class DataCollection {
	
	private Map<String, MatchedDataPair> data;
	private String title;
	private String xUnit;
	private String yUnit;
	
	/**
	 * This constructor defines the data, units, and the title
	 * of the collection
	 */
	public DataCollection(String title,String xUnit,String yUnit, Map<String, MatchedDataPair> data){
		this.data = data;
		this.xUnit = xUnit;
		this.yUnit = yUnit;
		this.title = title;	
	}
	
	/**
	 * This method fetches the title of the collection
	 */
	public String getTitle (){
		return title;
	}

	/**
	 * This method fetches data source 1s unit
	 */
	public String getXUnit(){
		return xUnit;
	}
	
	/**
	 * This method fetches data source 2s unit
	 */
	public String getYUnit(){
		return yUnit;
	}
	
	/**
	 * This method fetches the data of the matched data pair
	 */
	public Map<String, MatchedDataPair> getData(){
		return data;
	}
	
	/**
	 * This method shows the information of the data collection in
	 * a string. The information is title, data, and units
	 */
	public String toString(){
		return "data: " + data + "title: " + title + "xUnit: " + xUnit + "yUnit: " + yUnit;
	}
	
	@Override
	public boolean equals(Object o){
		DataCollection other = ((DataCollection)o);
		return (getTitle().equals(other.getTitle()) && xUnit.equals(other.getXUnit()) 
				&& yUnit.equals(other.getYUnit()) && data.equals(other.getData()));
	}
}
