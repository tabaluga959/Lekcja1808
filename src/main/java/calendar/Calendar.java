package calendar;

import calendar.Event;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Calendar {

    @XmlElement(name = "event")
    private List<Event> eventList = new ArrayList<>();
}