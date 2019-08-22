package example;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface Binding {

    String GREETINGS = "greetings";

    @Input(GREETINGS)
    KStream<String, String> events();

}
