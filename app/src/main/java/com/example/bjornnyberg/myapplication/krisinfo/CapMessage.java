package com.example.bjornnyberg.myapplication.krisinfo;

import java.util.Date;
import java.util.List;

/**
 * Created by bjornnyberg on 17/03/16.
 */
public class CapMessage {
    private final String identifier;
    private final String sender;
    private final Date sent;
    private final List<Info> infoData;

    public CapMessage(String identifier, String sender, Date sent, List<Info> infoData) {
        this.identifier = identifier;
        this.sender = sender;
        this.sent = sent;

        this.infoData = infoData;
    }

    @Override
    public String toString() {
        return "CapMessage{" +
                "identifier='" + identifier + '\'' +
                ", sender='" + sender + '\'' +
                ", sent='" + sent + '\'' +
                ", infoData=" + infoData +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public Info getInfo() {
        return infoData.get(0);
    }

    public class Info {
        private String headline;
        private String description;
        private String senderName;

        @Override
        public String toString() {
            return "infoData{" +
                    "Headline='" + headline + '\'' +
                    ", Description='" + description + '\'' +
                    ", SenderName='" + senderName + '\'' +
                    '}';
        }

        public Info(String headline) {
            this.headline = headline;
        }

        public String getDescription() {
            return description;
        }
    }
}
