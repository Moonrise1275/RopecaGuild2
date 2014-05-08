package moonrise.ropecaguild2.api;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import moonrise.ropecaguild2.api.ChatRG.EnumColor;
import moonrise.ropecaguild2.api.exception.GuildAlreadyExistException;
import moonrise.ropecaguild2.api.exception.GuildNotExistException;
import moonrise.ropecaguild2.api.exception.MemberAlreadyExistException;
import moonrise.ropecaguild2.api.exception.MemberNotExistException;
import moonrise.ropecaguild2.api.exception.UnauthorizedUserException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public interface IGuildRequester {
	
	/**
	 * 
	 * @param player : the player who attempt to make a guild
	 * @param guild : name of the guild
	 * @throws GuildAlreadyExistException
	 * @throws UnauthorizedUserException
	 */
	public void makeGuild(EntityPlayerMP player, String guild) throws GuildAlreadyExistException, UnauthorizedUserException;
	
	/**
	 * 
	 * @param player : the player who attempt to disband a guil
	 * @throws UnauthorizedUserException
	 * @throws GuildNotExistException
	 */
	public void disbandGuild(EntityPlayerMP player) throws UnauthorizedUserException, GuildNotExistException;
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @param target
	 * @param pos
	 * @throws UnauthorizedUserException
	 * @throws MemberNotExistException
	 * @throws GuildNotExistException
	 */
	public void setMemberPosition(EntityPlayerMP player, String target, EnumPosition pos) throws UnauthorizedUserException, MemberNotExistException, GuildNotExistException;
	
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @param target
	 * @param message
	 * @throws UnauthorizedUserException
	 * @throws GuildNotExistException
	 */
	public void invite(EntityPlayerMP player, String target, String message) throws UnauthorizedUserException, GuildNotExistException;
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @param inv
	 * @throws UnauthorizedUserException
	 * @throws GuildNotExistException
	 * @throws MemberAlreadyExistException
	 */
	public void accept(EntityPlayerMP player, Invitation inv) throws UnauthorizedUserException, GuildNotExistException, MemberAlreadyExistException;
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @throws GuildNotExistException
	 * @throws UnauthorizedUserException
	 * @throws MemberNotExistException
	 */
	public void escape(EntityPlayerMP player) throws GuildNotExistException, UnauthorizedUserException, MemberNotExistException;
	
	
	/**
	 * 
	 * @return : Set of all guild's name
	 */
	public Set<String> getGuilds();
	
	/**
	 * 
	 * @param guild
	 * @return all members of that guild
	 * @throws GuildNotExistException
	 */
	public Set<String> getMembers(String guild) throws GuildNotExistException;
	
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
	 * @param player : the player who attempt to do this action
	 * @param color
	 * @throws UnauthorizedUserException
	 * @throws GuildNotExistException
	 */
	public void setColor(EntityPlayerMP player, EnumColor color) throws UnauthorizedUserException, GuildNotExistException;
	
	/**
	 * 
	 * @param guild
	 * @return
	 * @throws GuildNotExistException
	 */
	public EnumColor getColor(String guild) throws GuildNotExistException;
	
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @param location
	 * @throws UnauthorizedUserException
	 * @throws GuildNotExistException
	 */
	public void setHall(EntityPlayerMP player, Location location) throws UnauthorizedUserException, GuildNotExistException;
	
	/**
	 * 
	 * @param guild
	 * @return
	 * @throws GuildNotExistException
	 */
	public Location getHall(String guild) throws GuildNotExistException;
	
	
	/**
	 * 
	 * @param guild
	 * @param tagname
	 * @param tag
	 * @throws GuildNotExistException
	 */
	public void setTag(String guild, String tagname, NBTTagCompound tag) throws GuildNotExistException;
	
	/**
	 * 
	 * @param guild
	 * @param tagname
	 * @return
	 * @throws GuildNotExistException
	 */
	public NBTTagCompound getTag(String guild, String tagname) throws GuildNotExistException;
	
	
	/**
	 * 
	 * @param player : the player who attempt to do this action
	 * @return
	 * @throws GuildNotExistException
	 */
	public String getGuild(String player) throws GuildNotExistException;
	
	public String getMaster(String guild) throws GuildNotExistException;
	
	public class Invitation implements Serializable {
		public final String guild;
		public final EntityPlayerMP sender;
		public final String message;
		public Invitation(String guild, EntityPlayerMP sender, String message) {
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
