package com.peony.event.domain.publisher;

public interface DomainEventPublisher {

    void publishEvent(Object event);

}
