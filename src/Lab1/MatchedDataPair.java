package Lab1;

/**
 * This class creates the variables that will
 * hold the values of data source 1 and
 * data source 2
 * 
 * @author Jonas Oster
 * @author Rashed Davodi
 * @author Jonatan Hogberg
 * @version 17/02 - 2016
 */

public class MatchedDataPair {
	
	private Double xValue ;
	private Double yValue;
	
	/**
	 * This constructor defines the values of
	 * data source 1 and data source 2
	 */
	public MatchedDataPair (double xValue, double yValue){
		
		this.xValue= xValue;
		this.yValue = yValue;
	}
	
	/**
	 * This method fetches the value of data source 1
	 */
	public Double getXvalue(){	
		return xValue;
	}
	
	/**
	 * This method fetches the value of data source 2
	 */
	public Double getYvalue(){
		return yValue;
	}
	
	/**
	 * This method shows the values of the data sources
	 * in a string
	 */
	public String toString(){
		return "[x: " + xValue + ", y: " + yValue + "]";
	}	
}
