package me.cooleg.bungeemessaging.OutgoingMessages;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.cooleg.bungeemessaging.MessageEnums.MessageType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

/**
 * Simplified way to write data out to a BungeeCord message.
 * Should work for basically any message except for the ForwardMessages.
 * For any messages that you need to add additional data, like a username for example, ByteArrayDataOutput methods are here for that.
 */
public class BungeeMessageOut implements ByteArrayDataOutput {

    // No privacy set on as this adds the most privacy while still being able to be used by subclasses.
    // ForwardMessageOut needs a lot of these and want to expose them juuuuust enough.
    static Plugin plugin = null;
    final ByteArrayDataOutput out = ByteStreams.newDataOutput();
    final Player player;
    final MessageType type;

    /**
     * Create a new BungeeMessageOut to be sent.
     * If the message type you have doesn't need additional data, you can just send it right after creating this!
     * @param player The player you want the message to be sent through. Doesn't matter in most cases.
     * @param type The type of message you are going to send.
     */
    public BungeeMessageOut(@Nonnull Player player, @Nonnull MessageType type) {
        this.player = player;
        this.type = type;
    }

    /**
     * Makes a new data output, and writes the MessageType string and your written data to it.
     * If you haven't written any data to this class, it won't write any additional data.
     */
    public void sendMessage() {
        final ByteArrayDataOutput data = ByteStreams.newDataOutput();
        data.writeUTF(type.getSubChannel());
        data.write(out.toByteArray());
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    /**
     * <b>For internal use only.<b/>
     */
    @Deprecated
    public static void setPlugin(@Nonnull Plugin sendingPlugin) {
        if (plugin != null) {return;}
        plugin = sendingPlugin;
    }

    // Make writing data to the message convenient.

    @Override
    public void write(int i) {
        out.write(i);
    }

    @Override
    public void write(@Nonnull byte[] bytes) {
        out.write(bytes);
    }

    @Override
    public void write(@Nonnull byte[] bytes, int i, int i1) {
        out.write(bytes, i, i1);
    }

    @Override
    public void writeBoolean(boolean b) {
        out.writeBoolean(b);
    }

    @Override
    public void writeByte(int i) {
        out.writeByte(i);
    }

    @Override
    public void writeShort(int i) {
        out.writeShort(i);
    }

    @Override
    public void writeChar(int i) {
        out.writeChar(i);
    }

    @Override
    public void writeInt(int i) {
        out.writeInt(i);
    }

    @Override
    public void writeLong(long l) {
        out.writeLong(l);
    }

    @Override
    public void writeFloat(float v) {
        out.writeFloat(v);
    }

    @Override
    public void writeDouble(double v) {
        out.writeDouble(v);
    }

    @Override
    public void writeChars(@Nonnull String s) {
        out.writeChars(s);
    }

    @Override
    public void writeUTF(@Nonnull String s) {
        out.writeUTF(s);
    }

    @Override
    public void writeBytes(@Nonnull String s) {
        out.writeBytes(s);
    }

    @Override
    public @Nonnull byte[] toByteArray() {
        return out.toByteArray();
    }
}
