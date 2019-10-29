package example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

    private final Binding binding;

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() throws IOException {
        String payload = "payload";
        Message<String> message = MessageBuilder.withPayload(payload).build();

        log.info("Sending message '{}'", payload);
        binding.greetings().send(message);
    }

}
