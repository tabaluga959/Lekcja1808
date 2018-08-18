package calendar;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

class EventXmlRepository implements EventRepository {

    private final PropertiesLoader propertiesLoader;
    private final LocalDateParser localDateParser;

    public EventXmlRepository(PropertiesLoader propertiesLoader,
                              LocalDateParser localDateParser) {
        this.propertiesLoader = propertiesLoader;
        this.localDateParser = localDateParser;

    }
    @Override
    public List<Event> getAll() {
        File xml = new File(propertiesLoader.getEventPath());
        Calendar unmarshal = JAXB.unmarshal(xml, Calendar.class);
        return unmarshal.getEventList();

    }

    @Override
    public Optional<Event> closestEvent() {
        return Optional.empty();
    }

    @Override
    public void save(Event event) throws IOException {

    }
}