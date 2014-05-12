package moonrise.ropecaguild2.api;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ChatUtil {
	
	public static ChatComponentText get(String text, EnumColor color, String command) {
		ChatComponentText chat = new ChatComponentText(text);
		if (command != null) {
			chat.setChatStyle(new ChatStyle().setColor(color.ecf).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command)));
		} else {
			chat.setChatStyle(new ChatStyle().setColor(color.ecf));
		}
		return chat;
	}
	
	public static ChatComponentText get(String text, EnumColor color) {
		return get(text, color, null);
	}
	
	public static ChatComponentText get(String text) {
		return get(text, EnumColor.white);
	}
	
	public static ChatComponentText sendInfo(String text) {
		ChatComponentText chat = get("[Info] ", EnumColor.aqua);
		chat.appendSibling(get(text));
		return chat;
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
