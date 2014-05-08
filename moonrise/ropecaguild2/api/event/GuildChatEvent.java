package moonrise.ropecaguild2.api.event;

import net.minecraft.util.IChatComponent;
import cpw.mods.fml.common.eventhandler.Event;

public class GuildChatEvent extends Event {
	
	public final String guild;
	public final String sender;
	public final String message;
	public IChatComponent chat;
	
	public GuildChatEvent(String guild, String sender, String message, IChatComponent chat) {
		this.guild = guild;
		this.sender = sender;
		this.message = message;
		this.chat = chat;
	}
}
