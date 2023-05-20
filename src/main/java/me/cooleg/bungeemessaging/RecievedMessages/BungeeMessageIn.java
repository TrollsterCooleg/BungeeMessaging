package me.cooleg.bungeemessaging.RecievedMessages;

import com.google.common.io.ByteArrayDataInput;
import me.cooleg.bungeemessaging.MessageEnums.MessageType;

import javax.annotation.Nonnull;

/**
 * Extremely simple way to read responses to past messages sent.
 * You can just send off a message, then when the response event comes in, just read the little bit of data you need.
 */
public class BungeeMessageIn {
    private final ByteArrayDataInput data;
    private final MessageType type;

    public BungeeMessageIn(@Nonnull ByteArrayDataInput data, MessageType type) {
        this.data = data;
        this.type = type;
    }

    public MessageType getMessageType() {
        return type;
    }
    public ByteArrayDataInput getData() {
        return data;
    }

}
