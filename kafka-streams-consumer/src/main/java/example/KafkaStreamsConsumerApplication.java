package example;

import brave.Tracing;
import brave.kafka.streams.KafkaStreamsTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
@EnableBinding(Binding.class)
public class KafkaStreamsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamsConsumerApplication.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public KafkaStreamsTracing kafkaStreamsTracer(Tracing tracing) {
        return KafkaStreamsTracing.create(tracing);
    }

}
