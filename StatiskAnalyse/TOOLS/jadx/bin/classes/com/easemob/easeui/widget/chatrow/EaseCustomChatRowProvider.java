package com.easemob.easeui.widget.chatrow;

import android.widget.BaseAdapter;
import com.easemob.chat.EMMessage;

public interface EaseCustomChatRowProvider {
    EaseChatRow getCustomChatRow(EMMessage eMMessage, int i, BaseAdapter baseAdapter);

    int getCustomChatRowType(EMMessage eMMessage);

    int getCustomChatRowTypeCount();
}
