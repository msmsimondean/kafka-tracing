package example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Binding {

    String GREETINGS = "greetings";

    @Output(GREETINGS)
    MessageChannel greetings();

}
