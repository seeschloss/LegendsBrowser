package legends.model.events.basic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import legends.WebServer;
import legends.helper.EventHelper;
import legends.model.basic.AbstractObject;
import legends.model.collections.basic.EventCollection;
import legends.xml.annotation.Xml;
import legends.xml.annotation.XmlIgnorePlus;
import legends.xml.annotation.XmlSubtypes;

@XmlSubtypes("type")
public class Event extends AbstractObject {
	protected static final Log LOG = LogFactory.getLog(WebServer.class);

	@Xml("year")
	protected int year;
	@Xml("seconds72")
	protected int seconds;
	@Xml("type")
	@XmlIgnorePlus
	protected String type;

	protected EventCollection collection;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EventCollection getCollection() {
		return collection;
	}

	public void setCollection(EventCollection collection) {
		this.collection = collection;
	}

	public void process() {

	}

	public String getDescription() {
		return getShortDescription();
	}

	public String getShortDescription() {
		return "[" + id + "] " + type;
	}

	public String getSentence() {
		return EventHelper.capitalize(getShortDescription());
	}

	public String getDate() {
		if (year != -1)
			if (seconds != -1)
				return EventHelper.getSeason(seconds) + " of " + year;
			else
				return "" + year;
		else
			return "a time before time";
	}

}
