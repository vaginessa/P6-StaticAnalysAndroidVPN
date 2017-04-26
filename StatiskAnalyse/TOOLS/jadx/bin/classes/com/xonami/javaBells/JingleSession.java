package com.xonami.javaBells;

import net.java.sip.communicator.impl.protocol.jabber.extensions.jingle.JingleIQ;

public interface JingleSession {
    String getSessionId();

    void handleContentAcept(JingleIQ jingleIQ);

    void handleContentAdd(JingleIQ jingleIQ);

    void handleContentModify(JingleIQ jingleIQ);

    void handleContentReject(JingleIQ jingleIQ);

    void handleContentRemove(JingleIQ jingleIQ);

    void handleDescriptionInfo(JingleIQ jingleIQ);

    void handleSecurityInfo(JingleIQ jingleIQ);

    void handleSessionAccept(JingleIQ jingleIQ);

    void handleSessionInfo(JingleIQ jingleIQ);

    void handleSessionInitiate(JingleIQ jingleIQ);

    void handleSessionReplace(JingleIQ jingleIQ);

    void handleSessionTerminate(JingleIQ jingleIQ);

    void handleTransportAccept(JingleIQ jingleIQ);

    void handleTransportInfo(JingleIQ jingleIQ);

    void handleTransportReject(JingleIQ jingleIQ);
}
