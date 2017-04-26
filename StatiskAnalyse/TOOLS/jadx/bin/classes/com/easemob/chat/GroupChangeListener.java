package com.easemob.chat;

public interface GroupChangeListener {
    void onApplicationAccept(String str, String str2, String str3);

    void onApplicationDeclined(String str, String str2, String str3, String str4);

    void onApplicationReceived(String str, String str2, String str3, String str4);

    void onGroupDestroy(String str, String str2);

    void onInvitationAccpted(String str, String str2, String str3);

    void onInvitationDeclined(String str, String str2, String str3);

    void onInvitationReceived(String str, String str2, String str3, String str4);

    void onUserRemoved(String str, String str2);
}
