package Lab1;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the interface DataSource
 * and uses its defined methods.
 * 
 * @author Jonas Oster
 * @author Rashed Davodi
 * @author Jonatan Hogberg
 * @version 17/02 - 2016
 */

public class ImplDataSource implements DataSource{
	
	private String name;
	private String unit;
	private Map<LocalDate, Double> loadData;
	
	/**
	 * This constructor defines the unit and the name
	 * of the data source, it also creates a hashmap
	 * for the map loadData.
	 */
	public ImplDataSource(String unit, String name ){
		this.name= name;
		this.unit= unit;
		this.loadData = new HashMap<LocalDate, Double>();	
	}

	/**
	 * This method fetches the name of the data source.
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * This method adds data to the hashmap loadData.
	 */
	public Map<LocalDate, Double>  addData (LocalDate localDate, Double value){
		loadData.put(localDate, value);
		return loadData;
	}

	/**
	 * This method fetches the unit of the data source.
	 */
	@Override
	public String getUnit() {
		return unit;
	}

	/**
	 * This method fetches the data from the hashmap loadData.
	 */
	@Override
	public Map<LocalDate, Double> getData() {
		return loadData;
	}

}
