package calendar;

import java.time.LocalDateTime;
import java.util.Optional;

class EventService {
    private final EventRepository repository;
    private final LocalDateParser localDateParser;

    EventService(EventRepository repository,
                 LocalDateParser localDateParser) {
        this.repository = repository;
        this.localDateParser = localDateParser;
    }

    void printAllEvents() {
//        for (Event event : repository.getAll()) {
//            printEvent(event);
//        }
        repository.getAll().stream()
                .map(this::getDisplayEvent)
                .forEach(System.out::println);
    }

    void printClosestEvent() {
        Optional<Event> event = repository.closestEvent();
        String display = event.map(this::getDisplayEvent)
                .orElse("Nie ma najblizszego wydarzenia");
        System.out.println(display);
    }

    void saveEvent(){

    }


    private String getDisplayEvent(Event event) {
        String displayString = localDateParser.toDisplayString(event.getDate());
        return "Event name:"
                + event.getName()
                +"\ndate: "
                + displayString;
    }

}
