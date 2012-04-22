package net.acampadas21.magias;


import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MyPlayerListener implements Listener {	
	
	public static Magias plugin;
	public String tipom;
	public MyPlayerListener(Magias instance, String tipo) {
		plugin = instance;
	}
	@EventHandler
	public void OnPlayerInteractEvent (PlayerInteractEvent event) {
		Player player = event.getPlayer();
		String acion = event.getAction().toString();
		ItemStack wand = event.getItem();
		if(acion != "RIGHT_CLICK_AIR" && acion != "RIGHT_CLICK_BLOCK") return;
		if(wand == null) {return;}
		if (acion == "RIGHT_CLICK_AIR" && wand.getType() == Material.BLAZE_ROD ) {
			if (tipom == "rojo" ) {
				player.launchProjectile(Fireball.class);
				Location loc = player.getEyeLocation();
				player.playEffect(loc, Effect.ENDER_SIGNAL, 0);
			} else {
				if (tipom == "blanco"){
					player.launchProjectile(Snowball.class);
				} else{
					if (tipom == "arquero"){
						player.launchProjectile(Arrow.class);
					}else{
						player.sendMessage("No eres un mago!");
					}
				}
			}			
		
		}
			if (player.hasPermission("magias.debug")) {
			player.sendMessage("Debug 1 get action :" + event.getAction());
			player.sendMessage("Debug 2 get EventName :" + event.getEventName());
			player.sendMessage("Debug 3 get Action :" + event.getAction());
			player.sendMessage("Debug 4 get Item :" + event.getItem());
			player.sendMessage("Debug 6 hasBlock :" + event.hasBlock());
			player.sendMessage("Debug 7 hasItem :" + event.hasItem());
			player.sendMessage("Debug 8 isBlockInHand :" + event.isBlockInHand());
			player.sendMessage("Debug 9 isCancelled :" + event.isCancelled());
			player.sendMessage("Debug 10 tipo :" + tipom);
			player.sendMessage("Estas maldito true si, false no. :" + player.hasPermission("magias.mago"));
			}
			
				
		
	}
	
	public void setMage(String tm, CommandSender sender) {
		if (sender.hasPermission("magias.mago")) {
			sender.sendMessage("Cambiando a mago " + ChatColor.RED + tm.toString());
			tipom = tm;
		} else {
			sender.sendMessage("No tienes permiso para ser un mago");
		}
		
	}
	}
	
