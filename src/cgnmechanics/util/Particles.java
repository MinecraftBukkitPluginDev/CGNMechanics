package cgnmechanics.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_11_R1.EnumParticle;
import net.minecraft.server.v1_11_R1.PacketPlayOutWorldParticles;

public class Particles {
	public static void playOut(EnumParticle particle, Location location, int xoffset, int yoffset, int zoffset, int speed, int count, String target) {
		Location loc = location;
		PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
				particle,
				true,
				(float)loc.getX(),
				(float)loc.getY(),
				(float)loc.getZ(),
				xoffset,
				yoffset,
				zoffset,
				speed,
				count,
				null);
		if (target.equalsIgnoreCase("sendall")) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				CraftPlayer cplayer = ((CraftPlayer)p);
				cplayer.getHandle().playerConnection.sendPacket(packet);
			}
		} else {
			@SuppressWarnings("deprecation")
			CraftPlayer cplayer = ((CraftPlayer)Bukkit.getPlayer(target));
			cplayer.getHandle().playerConnection.sendPacket(packet);
		}
	}
}
