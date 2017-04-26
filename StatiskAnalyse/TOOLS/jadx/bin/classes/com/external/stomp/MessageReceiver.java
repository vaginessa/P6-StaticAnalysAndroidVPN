package com.external.stomp;

import java.util.Map;

public interface MessageReceiver {
    void disconnect();

    boolean isClosed();

    void receive(Command command, Map map, String str);
}
