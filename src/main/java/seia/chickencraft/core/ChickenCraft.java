package seia.chickencraft.core;

import seia.chickencraft.handler.ChickenHandler;
import seia.chickencraft.handler.EggHandler;
import seia.chickencraft.handler.TooltipHandler;

/**
 * Core class of the entire mod. Also this class contains some cross-mods
 * methods.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class ChickenCraft {
	public static final String MODID = "chickencraft";
	public static final String NAME = "ChickenCraft";
	public static final String VERSION = "@VERSION@";

	public final ChickenHandler chickenHandler = new ChickenHandler(this);
	public final EggHandler eggHandler = new EggHandler(this);
	public final TooltipHandler tooltipHandler = new TooltipHandler(this);
}
