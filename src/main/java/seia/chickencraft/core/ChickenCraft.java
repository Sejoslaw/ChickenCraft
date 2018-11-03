package seia.chickencraft.core;

import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.genes.ChickenTypeGene;
import seia.chickencraft.genes.GenerationGene;
import seia.chickencraft.handler.ChickenHandler;
import seia.chickencraft.handler.EggHandler;
import seia.chickencraft.handler.PlayerHandler;
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

	// Flag for developers to allow for debug functionality in ChickenCraft.
	public static final boolean DEBUG = false;

	public final PlayerHandler playerHandler = new PlayerHandler(this);
	public final EggHandler eggHandler = new EggHandler(this);
	public final ChickenHandler chickenHandler = new ChickenHandler(this);
	public final TooltipHandler tooltipHandler = new TooltipHandler(this);

	public void registerBasicGenes() {
		GeneRegistry.registerGene(new ChickenTypeGene("Parent"));
		GeneRegistry.registerGene(new ChickenTypeGene("Chicken"));
		GeneRegistry.registerGene(new GenerationGene());
	}
}
