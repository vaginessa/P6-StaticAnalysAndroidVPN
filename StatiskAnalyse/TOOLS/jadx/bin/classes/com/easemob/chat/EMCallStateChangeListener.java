package com.easemob.chat;

public interface EMCallStateChangeListener {

    public enum CallError {
        ERROR_NONE("error_none"),
        ERROR_TRANSPORT("error_transport"),
        ERROR_INAVAILABLE("error_inavailable"),
        REJECTED("rejected"),
        ERROR_NORESPONSE("error_noresponse"),
        ERROR_BUSY("busy"),
        ERROR_NO_DATA("error_no_data"),
        ERROR_LOCAL_VERSION_SMALLER("error_local_version_smaller"),
        ERROR_PEER_VERSION_SMALLER("error_peer_version_smaller");
        
        private final String error;

        private CallError(String str) {
            this.error = str;
        }

        public String toString() {
            return this.error;
        }
    }

    public enum CallState {
        IDLE("idle"),
        RINGING("ringing"),
        ANSWERING("answering"),
        PAUSING("pausing"),
        CONNECTING("connecting"),
        CONNECTED("conntected"),
        ACCEPTED("accepted"),
        DISCONNNECTED("disconnected"),
        VOICE_PAUSE("voice_pause"),
        VOICE_RESUME("voice_resume"),
        VIDEO_PAUSE("video_pause"),
        VIDEO_RESUME("video_resume"),
        NETWORK_UNSTABLE("network_unstable"),
        NETWORK_NORMAL("network_normal");
        
        private final String state;

        private CallState(String str) {
            this.state = str;
        }

        public String toString() {
            return this.state;
        }
    }

    void onCallStateChanged(CallState callState, CallError callError);
}
