package org.zoodevelopers.upcoming_events.implementations.events;

public interface IEncryptFacade {

    String encode(String type, String data);

    String decode(String type, String data);
}
