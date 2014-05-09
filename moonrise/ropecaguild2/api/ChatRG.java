package moonrise.ropecaguild2.api;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatRG extends ChatComponentText {
	
	public ChatRG(String chat, EnumChatFormatting color, String command) {
		super(chat);
		if (command != null && !command.isEmpty()) {
			System.out.println(command + command + command);
			this.setChatStyle(new ChatStyle().setColor(color).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command)));
		} else {
			this.setChatStyle(new ChatStyle().setColor(color));	
		}
	}
	public ChatRG(String chat, EnumChatFormatting color) {
		this(chat, color, "");
	}
	
	public ChatRG(String chat) {
		this(chat, EnumChatFormatting.WHITE);
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
