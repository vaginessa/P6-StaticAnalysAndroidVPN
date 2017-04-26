package com.external.stomp;

import java.util.Map;

public interface Authenticatable extends MessageReceiver {
    void error(Map map, String str);

    Object token();
}
