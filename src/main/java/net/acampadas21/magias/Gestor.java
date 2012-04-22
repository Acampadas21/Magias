package net.acampadas21.magias;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Gestor {

	// Esta clase la vamos a utilizar para guardar datos sobre los tipos de magia y qué magia está usando cada jugador.
	
	public static final int NADA = 0;
	public static final int ROJO = 1;
	public static final int BLANCO = 2;
	public static final int ARQUERO = 3;
	
	private Magias plugin;
	private HashMap<Player, Integer> datos;
	
	public Gestor(Magias instance) {
		plugin = instance;
		datos = new HashMap<Player, Integer>();
	}
	
	public void cambiaMagia(Player p, int magia){
		if(datos.containsKey(p)) datos.remove(p);
		datos.put(p, new Integer(magia));
	}
	
	public int queMagia(Player p){
		if(!datos.containsKey(p)) return NADA;
		return datos.get(p);
	}
}
