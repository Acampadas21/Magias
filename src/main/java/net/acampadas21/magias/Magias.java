package net.acampadas21.magias;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Magias extends JavaPlugin{
		public static Magias plugin;
		public final Logger logger = Logger.getLogger("Minecraft");
		public final MyPlayerListener playerlistener = new MyPlayerListener(this, "rojo");
@Override
public void onEnable() {
	PluginDescriptionFile pdfFile = this.getDescription();
	this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " esta habilitado");
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(this.playerlistener, this);

}
@Override
public void onDisable() {
	PluginDescriptionFile pdfFile = this.getDescription();
	this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " esta deshabilitado");
}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String [] args) {
		if (!(sender instanceof Player)) {
	        sender.sendMessage(ChatColor.RED + "Tienes que ser un jugador!");
	        } else {
	        	if (args.length==1) {
	        		if (sender.hasPermission("magias.mago")){
		        		if(args[0].equalsIgnoreCase("rojo")){	        		
		        			playerlistener.setMage("rojo", sender) ;
		        		} else {
		        			if(args[0].equalsIgnoreCase("blanco") == true){
		        				playerlistener.setMage("blanco", sender) ;
		        			} else {
		        				if (args[0].equalsIgnoreCase("arquero")){
		        					playerlistener.setMage("arquero", sender);
		        				} else {
		        					sender.sendMessage("No existe esa clase de mago :/ s");
		        					}
		        				
		        			} 
		        		}
		        	}
	        	} else {
	        		sender.sendMessage("No has puesto el tipo de mago :/");
	        	}
	        	
		
	}
		return true; 
	}
		
}





