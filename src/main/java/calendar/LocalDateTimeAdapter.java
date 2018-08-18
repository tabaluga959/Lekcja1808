package calendar;


import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private final PropertiesLoader propertiesLoader;

    public LocalDateTimeAdapter() {
        propertiesLoader = new PropertiesLoader();
    }

    /**
     * Convert a value type to a bound type.
     *
     * @param v The value to be converted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return null;
    }

    /**
     * Convert a bound type to a value type.
     *
     * @param v The value to be convereted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return null;
    }
}

