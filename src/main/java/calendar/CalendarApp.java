package calendar;

    class CalendarApplication {
        public static void main(String[] args) {
            PropertiesLoader properties = new PropertiesLoader();
            EventLineParser parser = new EventLineParser();
            LocalDateParser localDateParser = new LocalDateParser(properties);
            EventRepository eventRepository = new EventXmlRepository(properties, localDateParser);
            EventService eventService = new EventService(eventRepository, localDateParser);
            eventService.printAllEvents();
        }
    }
