package com.example.practicalspringstreampublisher.infrastructure.messagin;


import com.example.practicalspringstreamcommon.events.ExampleDomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PublisherService {

    //A class with channel output defined
    private final Source source;


    private static final Logger log = LoggerFactory.getLogger(PublisherService.class);

    public PublisherService(Source source) {
        this.source = source;
    }

    public void publishChange(String action, String id) {

        log.debug("Sending message to kafka: {} for id: {}", action, id);


        //Event to be send
        ExampleDomainEvent exampleDomainEvent = new ExampleDomainEvent(action, id, ExampleDomainEvent.class.getName());

        //Use the channel output through Source interface
        source.output().send(MessageBuilder.withPayload(exampleDomainEvent).build());
    }
}
