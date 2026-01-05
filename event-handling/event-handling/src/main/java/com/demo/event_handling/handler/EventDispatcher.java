package com.demo.event_handling.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class EventDispatcher {

    private final Map<String, Handler> handlers = new HashMap<>();
    private final ObjectMapper objectMapper;

    public EventDispatcher(ApplicationContext ctx, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

        // Scan only handler beans (avoid listeners)
        ctx.getBeansOfType(EventHandler.class).values().forEach(bean -> {
            for (Method method : bean.getClass().getDeclaredMethods()) {
                KafkaEventHandler ann = method.getAnnotation(KafkaEventHandler.class);
                if (ann != null) {
                    handlers.put(ann.value(), new Handler(bean, method));
                }
            }
        });
    }

    public void dispatch(String eventType, String payload) {
        Handler handler = handlers.get(eventType);
        if (handler == null) {
            System.out.println("No handler found for event type: " + eventType);
            return;
        }

        try {
            Class<?> paramType = handler.method.getParameterTypes()[0];
            Object event = objectMapper.readValue(payload, paramType);
            handler.method.invoke(handler.bean, event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private record Handler(Object bean, Method method) {}
}
