package org.usfirst.irs1318.model;

import com.google.common.collect.*;

import java.util.HashMap;
import java.util.Map;

public class EmittedEvent {

    private final String eventName;
    private final ImmutableMap<String,String> properties;

    private EmittedEvent(String eventName, ImmutableMap<String,String> properties){
        this.eventName = eventName;
        this.properties = properties;
    }

    public String getEventName() {
        return eventName;
    }

    public static class Builder {
        private String eventName;
        private Map<String,String> properties = new HashMap<>();

        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }
        public Builder addProperties(String name, String value) {
            properties.put(name,value);
            return this;
        }
        public EmittedEvent build() {
            return new EmittedEvent(eventName, ImmutableMap.copyOf(properties));
        }
    }
}
