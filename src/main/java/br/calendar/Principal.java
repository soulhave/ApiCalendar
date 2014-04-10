package br.calendar;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.Person;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;


public class Principal {

	public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));

        try {
			CalendarService calendarService = new CalendarService("a");
			calendarService.setUserCredentials("ramon.mendes.bh@gmail.com", "1984$umrm@souza");
			URL feedUrl = new URL("http://www.google.com/calendar/feeds/default/allcalendars/full");
            CalendarFeed resultFeed = calendarService.getFeed(feedUrl, CalendarFeed.class);
            List<CalendarEntry> entries = resultFeed.getEntries();
            List<Person> authors = resultFeed.getAuthors();
            for (Person person : authors) {
				System.out.println(person.getName());
			}
            for (CalendarEntry c : entries) {
				System.out.println(c.getTitle().getPlainText());
			}
		} catch (IOException | ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
