package Lab1;
import java.time.LocalDate;
import java.util.Map;

/**
 * This interface defines the methods that will
 * fetch the name, unit and data 
 * 
 * @author Jonas Oster
 * @author Rashed Davodi
 * @author Jonatan Hogberg
 * @version 17/02 - 2016
 */

public interface DataSource {

	public String getName ();
	public String getUnit();
	public Map <LocalDate, Double> getData();	
}
