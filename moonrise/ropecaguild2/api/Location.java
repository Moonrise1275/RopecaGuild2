package moonrise.ropecaguild2.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

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

}
