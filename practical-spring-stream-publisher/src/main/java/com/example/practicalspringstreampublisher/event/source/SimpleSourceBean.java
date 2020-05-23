package com.example.practicalspringstreampublisher.event.source;

import com.example.practicalspringstreampublisher.dto.ExampleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    //A class with channel output defined
  private final Source source;


  private static final Logger log = LoggerFactory.getLogger(SimpleSourceBean.class);

  public SimpleSourceBean(Source source) {
    this.source = source;
  }

  public void publishChange(String action, String id) {

    log.debug("Sending message to kafka: {} for id: {}", action, id);


    //Pojo to be send
    ExampleModel.ExampleModelBuilder exampleMessage =
        ExampleModel.builder().action(action).id(id).name(ExampleModel.class.getName());

    //Use the channel output through Source interface
    source.output().send(MessageBuilder.withPayload(exampleMessage).build());
  }
}
