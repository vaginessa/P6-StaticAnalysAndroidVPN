package com.easemob.chat.core;

import org.jivesoftware.smack.ConnectionListener;

public interface q extends ConnectionListener {
    void onConnecting();

    void onConnectionSuccessful();
}
