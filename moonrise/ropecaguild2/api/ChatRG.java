package moonrise.ropecaguild2.api;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatRG implements IChatComponent {
	
	private String chat;
	private List<IChatComponent> siblings = Lists.newArrayList();
	private ChatStyle style;
	
	public ChatRG(String chat, EnumChatFormatting color, String command) {
		this.chat = chat;
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

	@Override
	public Iterator iterator() {
		return Iterators.concat(Iterators.forArray(new ChatRG[] {this}), ChatComponentStyle.createDeepCopyIterator(this.siblings));
	}
	@Override
	public IChatComponent setChatStyle(ChatStyle style) {
		this.style = style;
		return this;
	}
	@Override
	public ChatStyle getChatStyle() {
		return this.style;
	}
	@Override
	public IChatComponent appendText(String var1) {
		this.appendSibling(new ChatRG(var1));
		return this;
	}
	@Override
	public IChatComponent appendSibling(IChatComponent chat) {
		this.siblings.add(chat);
		return this;
	}
	@Override
	public String getUnformattedText() {
		StringBuilder sb = new StringBuilder(this.chat);
		for (IChatComponent c : this.siblings) {
			sb.append(c.getUnformattedText());
		}
		return sb.toString();
	}
	@Override
	public String getFormattedText() {
		StringBuilder sb = new StringBuilder(this.getChatStyle().getFormattingCode());
		sb.append(this.getUnformattedText());
		sb.append(EnumChatFormatting.RESET);
		for (IChatComponent c : this.siblings) {
			sb.append(c.getFormattedText());
		}
		return sb.toString();
	}
	@Override
	public List getSiblings() {
		return this.siblings;
	}
}
