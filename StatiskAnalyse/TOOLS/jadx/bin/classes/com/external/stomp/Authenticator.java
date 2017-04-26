package com.external.stomp;

import javax.security.auth.login.LoginException;

public interface Authenticator {
    boolean authorizeSend(Object obj, String str);

    boolean authorizeSubscribe(Object obj, String str);

    Object connect(String str, String str2) throws LoginException;
}
