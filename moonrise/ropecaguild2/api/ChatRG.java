package moonrise.ropecaguild2.api;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatRG extends ChatComponentStyle {
	
	private String chat;
	
	public ChatRG(String chat, EnumChatFormatting color, String cmd) {
		this.chat = chat;
		this.setChatStyle(this.getChatStyle().setColor(color));
		if (cmd != null && !cmd.isEmpty()) {
			this.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmd));
		}
	}
	public ChatRG(String chat, EnumChatFormatting color) {
		this(chat, color, "");
	}
	
	public ChatRG(String chat) {
		this(chat, EnumChatFormatting.WHITE);
	}

	@Override
	public String getUnformattedTextForChat() {
		return chat;
	}

	@Override
	public IChatComponent createCopy() {
		return new ChatRG(this.getFormattedText(), this.getChatStyle().getColor());
	}

	public enum EnumColor {
		black(EnumChatFormatting.BLACK),
		darkblue(EnumChatFormatting.DARK_BLUE),
		darkgreen(EnumChatFormatting.DARK_GREEN),
		darkaqua(EnumChatFormatting.DARK_AQUA),
		darkpurple(EnumChatFormatting.DARK_PURPLE),
		gold(EnumChatFormatting.GOLD),
		gray(EnumChatFormatting.GRAY),
		darkgray(EnumChatFormatting.DARK_GRAY),
		blue(EnumChatFormatting.BLUE),
		green(EnumChatFormatting.GREEN),
		aqua(EnumChatFormatting.AQUA),
		red(EnumChatFormatting.RED),
		lightpurple(EnumChatFormatting.LIGHT_PURPLE),
		yellow(EnumChatFormatting.YELLOW),
		white(EnumChatFormatting.WHITE);
		
		public final EnumChatFormatting ecf;
		
		private EnumColor(EnumChatFormatting e) {
			this.ecf = e;
		}
	}
}
