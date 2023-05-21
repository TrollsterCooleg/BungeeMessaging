package me.cooleg.bungeemessaging.RecievedMessages;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.cooleg.bungeemessaging.MessageEnums.ForwardMessageType;
import me.cooleg.bungeemessaging.MessageEnums.MessageType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

/**
 * Event triggered when message is received on BungeeCord channel. <br>
 * Only supports message types in either {@link MessageType} or {@link ForwardMessageType}. <br>
 * <b>Please don't trigger this event yourself unless you know what you are doing.</b>
 */
public class IncomingPluginMessageEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private MessageType type;
    private final BungeeMessageIn message;

    /**
     * @param player Player that this BungeeMessage was received through. Not relevant in most cases.
     * @param bytes The actual bytes received in the plugin channel message.
     */
    public IncomingPluginMessageEvent(@Nonnull Player player, @Nonnull byte[] bytes) {
        this.player = player;
        ByteArrayDataInput data = ByteStreams.newDataInput(bytes);
        String subChannel = data.readUTF();

        try {
            this.type = MessageType.valueOf(subChannel);
        } catch (IllegalArgumentException ex) {
            this.type = MessageType.FORWARD;
        }

        if (type == MessageType.FORWARD) {
            this.message = new ForwardMessageIn(data, subChannel);
        } else {
            this.message = new BungeeMessageIn(data, type);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public BungeeMessageIn getMessage() {
        return message;
    }

    public MessageType getMessageType() {
        return type;
    }

    @Override
    @Nonnull
    public HandlerList getHandlers() {
        return handlers;
    }

    @Nonnull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
