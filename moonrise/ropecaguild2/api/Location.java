package moonrise.ropecaguild2.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class Location {
	
	public final int dimension;
	
	public final double xpos;
	public final double ypos;
	public final double zpos;
	
	public final float yaw;
	public final float pitch;
	
	public Location(int d, double x, double y, double z, float w, float p) {
		this.dimension = d;
		this.xpos = x;
		this.ypos = y;
		this.zpos = z;
		this.yaw = w;
		this.pitch = p;
	}
	
	public Location(Entity entity) {
		this.dimension = entity.dimension;
		this.xpos = entity.posX;
		this.ypos = entity.posY;
		this.zpos = entity.posZ;
		this.yaw = entity.rotationYaw;
		this.pitch = entity.rotationPitch;
	}
	
	public void set(EntityPlayerMP player) {
		if (player.dimension != this.dimension) {
			player.travelToDimension(this.dimension);
		}
		player.playerNetServerHandler.setPlayerLocation(xpos, ypos, zpos, yaw, pitch);
	}
	
	public static Location loadFromTag(NBTTagCompound tag) {
		return new Location(tag.getInteger("Loc_dim"), tag.getDouble("Loc_x"), tag.getDouble("Loc_y"), tag.getDouble("Loc_z"), tag.getFloat("Loc_yaw"), tag.getFloat("Loc_pitch"));
	}
	public static NBTTagCompound saveToTag(Location loc) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Loc_dim", loc.dimension);
		tag.setDouble("Loc_x", loc.xpos);
		tag.setDouble("Loc_y", loc.xpos);
		tag.setDouble("Loc_z", loc.xpos);
		tag.setFloat("Loc_yaw", loc.yaw);
		tag.setFloat("Loc_pitch", loc.pitch);
		return tag;
	}

}
