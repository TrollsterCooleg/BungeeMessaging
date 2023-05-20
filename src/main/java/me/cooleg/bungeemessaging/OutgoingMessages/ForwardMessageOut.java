package me.cooleg.bungeemessaging.OutgoingMessages;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.cooleg.bungeemessaging.MessageEnums.ForwardMessageType;
import me.cooleg.bungeemessaging.MessageEnums.MessageType;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

/**
 * Specific implementation of {@link BungeeMessageOut} to simplify the writing of "forward" bungee messages. <br>
 * Typically would be a slight pain, writing the sub channel, target, byte array length, etc. <br>
 * Using this, any data you write is the data that goes into the message, so you don't have to deal with that stuff.
 */
public class ForwardMessageOut extends BungeeMessageOut {

    private final String target;
    private final String subChannel;

    /**
     * Initialize a ForwardMessage instead of a regular old BungeeMessage.
     *
     * @see <a href="https://www.spigotmc.org/wiki/bukkit-bungee-plugin-messaging-channel/">Bungee Message Channel Info</a>
     * @param player For sending any plugin messages, you need a player to send it through. This doesn't matter in most cases.
     * @param type Is this message going to a server, or to a player?
     * @param target If this is to a server, you can specify a server name, "ONLINE" for online servers, or "ALL" for all servers. If this is to a player, put their name.
     * @param subChannel Use the same subchannel name for sending and receiving the same messages to differentiate between messages.
     */
    public ForwardMessageOut(@Nonnull Player player, @Nonnull ForwardMessageType type, @Nonnull String target, @Nonnull String subChannel) {
        super(player, MessageType.valueOf(type.toString()));
        this.target = target;
        this.subChannel = subChannel;
    }

    @Override
    public void sendMessage() {
        final ByteArrayDataOutput data = ByteStreams.newDataOutput();
        // Tell it what type of forwarding we are doing
        data.writeUTF(type.getSubChannel());
        // For who or what server it is for
        data.writeUTF(target);
        // Say what type of message this is
        data.writeUTF(subChannel);
        // Then, send the length of the data and the data itself.
        data.writeShort(out.toByteArray().length);
        data.write(out.toByteArray());

        // Aaaaand send it all off!
        player.sendPluginMessage(plugin, "BungeeCord", data.toByteArray());
    }

}
