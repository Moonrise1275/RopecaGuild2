package moonrise.ropecaguild2.api;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import moonrise.ropecaguild2.api.ChatUtil.EnumColor;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public interface IGuildRequester {
	
	/**
	 * 
	 * @param sender : the player who attempt to make a guild
	 * @param guild : name of the guild
	 * @return true if successed.
	 */
	public boolean makeGuild(String sender, String guild);
	
	/**
	 * 
	 * @param sender : the player who attempt to disband a guil
	 * @return true if successed.
	 */
	public boolean disbandGuild(String sender);
	
	/**
	 * 
	 * @param sender : the player who attempt to do this action
	 * @param target : the player which sender want to set position
	 * @param pos
	 * @return true if successed.
	 */
	public boolean setMemberPosition(String sender, String target, EnumPosition pos);
	
	
	/**
	 * 
	 * @param sender : the player who attempt to do this action
	 * @param target : the player which sender want to invite
	 * @param message
	 * @return true if successed
	 */
	public boolean invite(String sender, String target, String message);
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @param inv : invitation which sender want to accept
	 * @return true if successed.
	 */
	public boolean accept(String sender, Invitation inv);
	
	/**
	 * 
	 * @param sender : the player who attempt to do this action
	 * @return true if successed. false if player is already solo
	 */
	public boolean escape(String sender);
	
	
	/**
	 * 
	 * @return : Set of all guild's name
	 */
	public Set<String> getGuilds();
	
	/**
	 * 
	 * @param guild
	 * @return get of all members of that guild. null if guild is not exist
	 */
	public Set<String> getMembers(String guild);
	
	/**
	 * 
	 * @param target
	 * @return given member's position
	 */
	public EnumPosition getMemberPosition(String target);
	
	/**
	 * 
	 * @param target
	 * @return list of invitations which is given to that player
	 */
	public List<Invitation> getInvitations(String target);
	
	
	/**
	 * 
	 * @param sender : the player who attempt to do this action
	 * @param color
	 * @return true if successed. false if guild is not exist
	 */
	public boolean setColor(String sender, EnumColor color);
	
	/**
	 * 
	 * @param guild
	 * @return given guild's symbol color. null if that guild is not exist
	 */
	public EnumColor getColor(String guild);
	
	
	/**
	 * 
	 * @param sender : the player who attempt to do this action
	 * @param location
	 * @return true if successed. false if guild is not exist.
	 */
	public boolean setHall(String sender, Location location);
	
	/**
	 * 
	 * @param guild
	 * @return Location instance which is guild's main hall. null if guild is not exist
	 */
	public Location getHall(String guild);
	
	
	/**
	 * 
	 * @param guild
	 * @param tagname
	 * @param tag
	 * @return true if successed. false if guild is not exist
	 */
	public boolean setTag(String guild, String tagname, NBTTagCompound tag);
	
	/**
	 * 
	 * @param guild
	 * @param tagname
	 * @return NBT tag which holds guild's data. null if guild is not exist
	 */
	public NBTTagCompound getTag(String guild, String tagname);
	
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @return guild's name that player is included. null if player is solo
	 */
	public String getGuild(String player);
	
	
	/**
	 * 
	 * @param guild
	 * @return master of that guild. null if guild is not exist
	 */
	public String getMaster(String guild);
	
	public class Invitation implements Serializable {
		public final String guild;
		public final String sender;
		public final String message;
		public Invitation(String guild, String sender, String message) {
			this.guild = guild;
			this.sender = sender;
			this.message = message;
		}
	}
	
	public enum EnumPosition implements Serializable {
		GuildMaster(4, "GM"),
		ViceMaster(3, "V"),
		Excutive(2, "E"),
		Member(1, "M"),
		Solo(0, "S");
		
		public final int level;
		public final String symbol;
		
		private EnumPosition(int lv, String sym) {
			this.level = lv;
			this.symbol = sym;
		}
	}
	
}
