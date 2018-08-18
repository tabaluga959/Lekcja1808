package calendar;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EventLineParser {

    String toLine(Event event){
        return event.getDate() + " ; " +event.getName();
    }

    Optional<Event> toEventByRegex(String line){
        Pattern compile = Pattern.compile("(.+) ; (.*)");
        Matcher matcher = compile.matcher(line);
        if (matcher.find()) {
            String date = matcher.group(1);
            String name = matcher.group(2);
            return Optional.of(new Event(name, date));
        }
        return Optional.empty();
    }
    Optional<Event> toEventBySplit(String line){
        //122342 23:42 ;  kfjldkjfkjsfdkl; jhjhk
        String[] split = line.split(";",1);
        if (split.length == 2) {
            String date = split[0].trim();
            String name = split[1].trim();
            return Optional.of(new Event(name,date));
        }
        return Optional.empty();
    }
}