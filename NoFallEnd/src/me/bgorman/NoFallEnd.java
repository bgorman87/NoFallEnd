package me.bgorman;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoFallEnd extends JavaPlugin
  implements Listener
{

  public void onEnable() {
     Bukkit.getPluginManager().registerEvents(this, this);
     getLogger().info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
     getLogger().info("~   NoFallEnd has been enabled   ~");
     getLogger().info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  @EventHandler
  public void onEntityDamage(EntityDamageEvent e) {
     if ((e.getEntity() instanceof Player)) {
       Player p = (Player)e.getEntity();
       if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && p.getWorld().getName().equals("world_the_end")) {
           e.setCancelled(true);
      }
   }
 }
}