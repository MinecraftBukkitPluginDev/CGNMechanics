package cgnmechanics.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import cgnmechanics.Main;
import cgnmechanics.util.Particles;
import net.minecraft.server.v1_11_R1.EnumParticle;

public class PlayerDeath implements Listener {
	
	/**
	 * Mechanics:
	 * On a player's death he becomes a spectator
	 * and remains it for 3s meanwhile being able to
	 * explore the world.
	 */
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = (Player)event.getEntity();
		player.setHealth(player.getMaxHealth());
		player.setFireTicks(0);
		player.setFoodLevel(20);
		player.setGameMode(GameMode.SPECTATOR);
		new BukkitRunnable() {
			int temp_seconds = 0;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if (temp_seconds == 3) {
					player.sendTitle("§e§lRESPAWNED", "§7You can again enjoy your game.");
					player.setGameMode(GameMode.SURVIVAL);
					player.teleport(player.getWorld().getSpawnLocation());
					Particles.playOut(EnumParticle.PORTAL, player.getLocation(), 1, 1, 1, 2, 5000/2, "sendall");
					Particles.playOut(EnumParticle.ENCHANTMENT_TABLE, player.getLocation(), 1, 1, 1, 2, 5000/2, "sendall");
					player.sendMessage("§aYou are now invulnerable for §720§a seconds.");
					player.setNoDamageTicks(20*20);
					new BukkitRunnable() {
						
						int ticks = 0;

						@Override
						public void run() {
							if (ticks == 20*20) {
								player.sendMessage("§cYou are vulnerable again.");
								Particles.playOut(EnumParticle.FLAME, player.getLocation(), 2, 2, 2, 2, 3000, "sendall");
								this.cancel();
							} else {
								player.setFireTicks(0);
								for (PotionEffect effect : player.getActivePotionEffects()) {
									player.removePotionEffect(effect.getType());
								}
								player.setFoodLevel(20);
								ticks ++;
								Particles.playOut(EnumParticle.ENCHANTMENT_TABLE, player.getLocation(), 1, 1, 1, 0, 20, "sendall");
							}
						}
						
					}.runTaskTimerAsynchronously(Main.getInstance(), 0, 1);
					this.cancel();
				} else {
					player.sendTitle("§2§l"+(3 - temp_seconds), "§7.. seconds remaining until respawn");
					temp_seconds = temp_seconds + 1;
				}
			}
			
		}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20*3/3);
	}
	
}
