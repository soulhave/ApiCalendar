package br.calendar;

import java.io.IOException;
import java.net.URL;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.extensions.When;
import com.google.gdata.data.extensions.Where;
import com.google.gdata.util.ServiceException;

public class Insert {
	public static void main(String[] args) {
		try {
			CalendarService calendarService = new CalendarService("Application Test");
			String email = "ramon.mendes.bh@gmail.com";
//			String agenda = "igmtbueg2jdgusnu9o580jkbh0@group.calendar.google.com";
			String agenda = email;
			calendarService.setUserCredentials(email, "1984$umrm@souza");
//			URL postURL = new URL("http://www.google.com/calendar/feeds/"+email+"/private/full");
			URL postURL = new URL("http://www.google.com/calendar/feeds/"+agenda+"/private/full");
			CalendarEventEntry myEvent = new CalendarEventEntry();

			//Set the title and description
			myEvent.setTitle(new PlainTextConstruct("Teste de Inclusão de Evento"));
			myEvent.setContent(new PlainTextConstruct("Uhu Feito!"));

			//Create DateTime events and create a When object to hold them, then add 
			//the When event to the event
			DateTime startTime = DateTime.parseDateTime("2014-04-10T15:00:00-08:00");
			DateTime endTime = DateTime.parseDateTime("2014-04-10T15:00:00-08:00");
			When eventTimes = new When();
			eventTimes.setStartTime(startTime);
			eventTimes.setEndTime(endTime);
			myEvent.addTime(eventTimes);
			Where local = new Where();
			local.setValueString("Rua Luiz Bezerra de Mello, 54");
			myEvent.addLocation(local);
			// POST the request and receive the response:
			CalendarEventEntry insertedEntry = calendarService.insert(postURL, myEvent);
			System.out.println(insertedEntry.getStatus().getValue());
			
		} catch (IOException | ServiceException e) {
			e.printStackTrace();
		}
	}
}
