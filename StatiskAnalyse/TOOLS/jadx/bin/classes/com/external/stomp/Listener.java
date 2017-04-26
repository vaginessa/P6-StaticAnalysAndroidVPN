package com.external.stomp;

import java.util.Map;

public interface Listener {
    void message(Map map, String str);
}
