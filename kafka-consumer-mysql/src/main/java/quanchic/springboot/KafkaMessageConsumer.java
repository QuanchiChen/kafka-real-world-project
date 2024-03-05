package quanchic.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import quanchic.springboot.model.WikimediaData;
import quanchic.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaMessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    private final WikimediaDataRepository dataRepository;

    @Autowired
    public KafkaMessageConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recent_changes", groupId = "myConsumerGroup")
    public void consume(String message) {
        logger.info(String.format("New Kafka Message Received: %s", message));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setContent(message);

        dataRepository.save(wikimediaData);
    }
}
