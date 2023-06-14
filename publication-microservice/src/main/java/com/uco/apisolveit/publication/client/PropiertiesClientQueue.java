package com.uco.apisolveit.publication.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "client.queue")
public class PropiertiesClientQueue {

    private String exchangeName;
    private String routingKey;
    private String queueName;

    public String getExchangeName(){return exchangeName;}

    public String getRoutingKeyName(){
        return routingKey;
    }

    public void setRoutingKey(String routingKey){
        this.routingKey = routingKey;
    }

    public String getQueueName(){return queueName;}

    public void setExchangeName(String exchangeName){
        this.exchangeName = exchangeName;
    }

    public void setQueueName(String queueName){
        this.queueName = queueName;
    }
}
