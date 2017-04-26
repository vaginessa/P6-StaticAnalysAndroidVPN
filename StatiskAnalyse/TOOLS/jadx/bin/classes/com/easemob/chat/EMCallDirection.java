package com.easemob.chat;

enum EMCallDirection {
    OUTGOING("outgoing"),
    INCOMING("incoming"),
    NONE("none");
    
    private String direction;

    private EMCallDirection(String str) {
        this.direction = str;
    }

    public String toString() {
        return this.direction;
    }
}
