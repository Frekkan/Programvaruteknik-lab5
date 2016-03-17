package lab5;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import Lab1.DataSource;
import workshop.JsonToMapParser;
import workshop.UrlFetcher;

/**
 *
 * @author Fredrik
 * @author Rashed
 */
public class FootballSpectatorSource implements DataSource
{
    @Override
    public String getName()
    {
	return "Antal åskådare per matchdag i fotbollsallsvenskan";
    }

    @Override
    public String getUnit()
    {
	return "Antal åskådare";
    }

    @Override
    public Map<LocalDate, Double> getData()
    {
	UrlFetcher fetcher = new UrlFetcher(
		"http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=240");
	JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());

	Map<String, Object> data = parser.getResult();
	Map<LocalDate, Double> result = new TreeMap<>();

	for (Map<String, Object> event : (List<Map<String, Object>>) data.get("events"))
	{
	    if (event.containsKey("facts"))
	    {
		Map<String, Object> facts = (Map<String, Object>) event.get("facts");
		if (facts.containsKey("spectators"))
		{
		    LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));

		    Long spectators = (Long) facts.get("spectators");

		    result.put(date, Double.valueOf(spectators));
		}
	    }
	}
	return result;
    }
    public static void main (String[] args){
	FootballSpectatorSource source = new FootballSpectatorSource();
	
	for (Entry<LocalDate,Double>matchedData:source.getData().entrySet()) {
	    System.out.println(matchedData);
	}
	
    }
}

