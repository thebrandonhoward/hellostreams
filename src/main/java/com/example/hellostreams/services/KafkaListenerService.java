package com.example.hellostreams.services;

import com.example.hellostreams.bindings.KafkaListenerBindings;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(KafkaListenerBindings.class)
public class KafkaListenerService {

    @StreamListener("input-channel-1")
    public void process(KStream<String,String> kstream) {
        kstream.foreach((k,v) -> log.info("Key is {} and the value is {}", k, v));
    }

}
