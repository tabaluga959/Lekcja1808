package calendar;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

interface EventRepository {
    List<Event> getAll();
    Optional<Event> closestEvent();
    void save(Event event) throws IOException;
}