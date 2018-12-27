package cgnmechanics.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathMessage implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		EntityDamageEvent e = event.getEntity().getLastDamageCause();
		if (e.getCause() == DamageCause.BLOCK_EXPLOSION) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7lit the wrong block on fire.");
		} else if (e.getCause() == DamageCause.DROWNING) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7Went swimming in Chernobyl.");
		} else if (e.getCause() == DamageCause.ENTITY_ATTACK) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7became a victim of a murdery because of§c "+event.getEntity().getKiller());
		} else if (e.getCause() == DamageCause.ENTITY_EXPLOSION) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7went to the party with a guy with an explosive mind!");
		} else if (e.getCause() == DamageCause.FALL) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7forget to get into the plane before start.");
		} else if (e.getCause() == DamageCause.FALLING_BLOCK) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7took part in the §4GRaVIty aNViL§c masacra§7!");
		} else if (e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7switched places with the sausage on the BBQ.");
		} else if (e.getCause() == DamageCause.FLY_INTO_WALL) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7didn't look where they fly.");
		} else if (e.getCause() == DamageCause.HOT_FLOOR) {
			event.setDeathMessage("§7The ground temperature was too high for §c"+event.getEntity().getDisplayName()+"§7.");
		} else if (e.getCause() == DamageCause.LAVA) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7played \"The floor is lava\"");
		} else if (e.getCause() == DamageCause.LIGHTNING) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7stod under a tree during thunder.");
		} else if (e.getCause() == DamageCause.MAGIC) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7made Gargamel nervous.");
		} else if (e.getCause() == DamageCause.POISON) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7drank a bottle of green fluid.");
		} else if (e.getCause() == DamageCause.PROJECTILE) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7was sh0t.");
		} else if (e.getCause() == DamageCause.STARVATION) {
			event.setDeathMessage("§7A diet was too strong for §c"+event.getEntity().getDisplayName()+"§7. lmao");
		} else if (e.getCause() == DamageCause.SUICIDE) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7decided to end their life.");
		} else if (e.getCause() == DamageCause.VOID) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7saddly failed his jump of the faith ... into the void.");
		} else if (e.getCause() == DamageCause.WITHER) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7lost the battle of his life.");
		} else if (e.getCause() == DamageCause.SUFFOCATION) {
			event.setDeathMessage("§c"+event.getEntity().getDisplayName()+" §7lost oxygen.");
		}
	}
	
}
