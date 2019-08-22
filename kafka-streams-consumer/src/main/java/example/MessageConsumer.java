package example;

import brave.kafka.streams.KafkaStreamsTracing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class MessageConsumer {

    private final KafkaStreamsTracing kafkaStreamsTracing;

    @StreamListener
    public void process(@Input(Binding.GREETINGS) KStream<String, String> greetings) {
        greetings
            .process(kafkaStreamsTracing.foreach("forEach", (key, value) -> {
                log.info("Received message '{}'", value);
            }));
    }

}
