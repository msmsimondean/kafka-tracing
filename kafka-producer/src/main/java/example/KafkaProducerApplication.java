package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.DefaultKafkaHeaderMapper;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBinding(Binding.class)
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Bean
    public DefaultKafkaHeaderMapper headerMapper() {
        DefaultKafkaHeaderMapper headerMapper = new DefaultKafkaHeaderMapper("*");
        headerMapper.setMapAllStringsOut(true);
        return headerMapper;
    }

}
