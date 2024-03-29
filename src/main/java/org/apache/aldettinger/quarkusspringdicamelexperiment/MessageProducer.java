package org.apache.aldettinger.quarkusspringdicamelexperiment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Value("${greeting.message}")
    String message;

    public String getPrefix() {
        return message;
    }
}
