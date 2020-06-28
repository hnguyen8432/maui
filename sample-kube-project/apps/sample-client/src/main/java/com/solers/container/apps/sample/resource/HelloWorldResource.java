package com.solers.container.apps.sample.resource;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/")
public class HelloWorldResource {
    private static final Logger logger = getLogger(HelloWorldResource.class);

    @Produce(uri = "direct:send-message")
    private ProducerTemplate sender;

    @GetMapping
    public String sayHello(){
        String greeting = "Hello world\n";
        logger.info("Request for \"/\" received. Return '{}'", greeting);
        return  greeting;
    }

    @GetMapping("/{name}")
    public String sayHelloTo(@PathVariable String name) {
        String greeting = "Hello " + name + "\n";
        logger.info("Request for \"/{}\" received. Return '{}'", name, greeting);
        return greeting;
    }

    @GetMapping("/publish/message")
    public String publishMessage( @RequestParam(name = "message") String message) {
        logger.info("Publishing message \"{}\". to {}", message, "queue-send");
        sender.sendBody(message);
        return "ok";
    }
}
