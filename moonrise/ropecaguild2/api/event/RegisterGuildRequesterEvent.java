package moonrise.ropecaguild2.api.event;

import moonrise.ropecaguild2.api.IGuildRequester;
import cpw.mods.fml.common.eventhandler.Event;

public class RegisterGuildRequesterEvent extends Event {
	
	private IGuildRequester guilds;
	
	public RegisterGuildRequesterEvent(IGuildRequester gr) {
		this.guilds = gr;
	}
	
	public IGuildRequester getGuildRequester() {
		return this.guilds;
	}
}
