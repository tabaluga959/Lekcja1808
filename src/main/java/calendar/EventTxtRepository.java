package calendar;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EventTxtRepository implements EventRepository {
    private PropertiesLoader propertiesLoader;
    private final EventLineParser parser;
    private final LocalDateParser localDateParser;

    public EventTxtRepository(PropertiesLoader propertiesLoader,
                              EventLineParser lineParser,
                              LocalDateParser localDateParser) {
        this.propertiesLoader = propertiesLoader;
        this.parser = lineParser;
        this.localDateParser = localDateParser;
    }

    @Override
    public List<Event> getAll() {
        try {
            Path path = Paths.get(propertiesLoader.getEventPath());
            Stream<Event> eventStream = Files.lines(path)
                    .map(parser::toEventByRegex)
                    .filter(Optional::isPresent)
                    .map(Optional::get);
            return eventStream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Event> closestEvent() {
        List<Event> all = getAll();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime closestTimeFromNow = LocalDateTime.MAX;
        Event closest = null;
        for (Event event : all) {
            String date = event.getDate();
            LocalDateTime localDateTime = localDateParser.toLocalDateTime(date);
            if (localDateTime.isAfter(now) && localDateTime.isBefore(closestTimeFromNow)) {
                closestTimeFromNow = localDateTime;
                closest = event;
            }
        }
        return Optional.ofNullable(closest);
    }

    @Override
    public void save(Event event) throws IOException {
        Path path = Paths.get(propertiesLoader.getEventPath());
        String line = parser.toLine(event);
        Files.write(path,
                line.getBytes(),
                StandardOpenOption.APPEND);
    }


}