package me.cooleg.bungeemessaging.RecievedMessages;

import com.google.common.io.ByteArrayDataInput;
import me.cooleg.bungeemessaging.MessageEnums.MessageType;

import javax.annotation.Nonnull;

/**
 * Simplifies reading incoming messages from other servers for either of the ForwardMessage types.
 * Automatically reads off the channel name and length of data, so just like the BungeeMessageIn class,
 * the only thing you need to read yourself is the actual data.
 */
public class ForwardMessageIn extends BungeeMessageIn {
    private final String channelName;
    private final short dataLength;
    public ForwardMessageIn(@Nonnull ByteArrayDataInput data, String channelName) {
        super(data, MessageType.Forward);
        // Make sure all the data is up to-date before reading from it.
        ByteArrayDataInput info = this.getData();
        this.channelName = channelName;
        dataLength = info.readShort();
    }

    public String getChannelName() {
        return channelName;
    }

    public short getDataLength() {
        return dataLength;
    }

}
