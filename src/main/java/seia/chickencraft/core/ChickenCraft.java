package seia.chickencraft.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import seia.chickencraft.api.core.ChickenCraftConstants;
import seia.chickencraft.api.registries.ChickenTypeRegistry;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.genes.ChickenTypeGene;
import seia.chickencraft.genes.DecreaseEggSpawningTicksGene;
import seia.chickencraft.genes.GenerationGene;
import seia.chickencraft.genes.ItemProduceGene;
import seia.chickencraft.genes.MutateEggGene;
import seia.chickencraft.genes.MutationChanceGene;
import seia.chickencraft.handler.ChickenHandler;
import seia.chickencraft.handler.EggHandler;
import seia.chickencraft.handler.PlayerHandler;
import seia.chickencraft.handler.TooltipHandler;
import seia.chickencraft.models.ChickenType;

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
		GeneRegistry.registerGene(new ChickenTypeGene(ChickenCraftConstants.CHICKEN_TYPE_NAME_PARENT));
		GeneRegistry.registerGene(new ChickenTypeGene(ChickenCraftConstants.CHICKEN_TYPE_NAME_CHICKEN));
		GeneRegistry.registerGene(new GenerationGene());
		GeneRegistry.registerGene(new MutationChanceGene());
		GeneRegistry.registerGene(new DecreaseEggSpawningTicksGene());
		GeneRegistry.registerGene(new ItemProduceGene());
		GeneRegistry.registerGene(new MutateEggGene());
	}

	public void registerChickenTypes() {
		// Layer 1

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_NORMAL, new ItemStack[] {},
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_ADVENTURER, ChickenCraftConstants.CHICKEN_TYPE_NATURE,
						ChickenCraftConstants.CHICKEN_TYPE_MONSTERY, ChickenCraftConstants.CHICKEN_TYPE_STONE }));

		// Layer 2

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_ADVENTURER,
				new ItemStack[] { new ItemStack(Items.MAP) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_FARMER, ChickenCraftConstants.CHICKEN_TYPE_HUNTER }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_NATURE,
				new ItemStack[] { new ItemStack(Blocks.RED_FLOWER), new ItemStack(Blocks.YELLOW_FLOWER) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_DESERT, ChickenCraftConstants.CHICKEN_TYPE_WATER,
						ChickenCraftConstants.CHICKEN_TYPE_FOREST }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_MONSTERY,
				new ItemStack[] { new ItemStack(Items.BONE) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_NORMAL_MONSTERY,
						ChickenCraftConstants.CHICKEN_TYPE_NETHER, ChickenCraftConstants.CHICKEN_TYPE_ENDER }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_STONE,
				new ItemStack[] { new ItemStack(Blocks.STONE), new ItemStack(Items.CLAY_BALL),
						new ItemStack(Blocks.GRAVEL) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_CAVE, ChickenCraftConstants.CHICKEN_TYPE_MINER }));

		// Layer 3

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_FARMER,
				new ItemStack[] { new ItemStack(Items.BEETROOT_SEEDS), new ItemStack(Items.MELON_SEEDS),
						new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.CARROT), new ItemStack(Items.POTATO), new ItemStack(Items.REEDS) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_HUNTER,
				new ItemStack[] { new ItemStack(Items.CHICKEN), new ItemStack(Items.FEATHER),
						new ItemStack(Items.LEATHER), new ItemStack(Items.BEEF), new ItemStack(Items.PORKCHOP),
						new ItemStack(Items.RABBIT), new ItemStack(Items.MUTTON) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_DESERT,
				new ItemStack[] { new ItemStack(Blocks.CACTUS), new ItemStack(Blocks.SAND) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_WATER,
				new ItemStack[] { new ItemStack(Items.FISH), new ItemStack(Blocks.SPONGE), new ItemStack(Items.DYE) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_ICE }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_FOREST,
				new ItemStack[] { new ItemStack(Items.APPLE), new ItemStack(Blocks.LOG) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_NORMAL_MONSTERY,
				new ItemStack[] { new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.BONE),
						new ItemStack(Items.STRING), new ItemStack(Items.SPIDER_EYE),
						new ItemStack(Items.GUNPOWDER) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_NETHER, new ItemStack[] {
				new ItemStack(Items.QUARTZ), new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Items.GHAST_TEAR),
				new ItemStack(Items.GOLD_NUGGET), new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER),
				new ItemStack(Items.NETHER_WART), new ItemStack(Blocks.SOUL_SAND), new ItemStack(Items.MAGMA_CREAM) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_ENDER,
				new ItemStack[] { new ItemStack(Items.CHORUS_FRUIT), new ItemStack(Blocks.END_ROD),
						new ItemStack(Blocks.END_STONE), new ItemStack(Items.ENDER_PEARL),
						new ItemStack(Items.SHULKER_SHELL) },
				new String[] { ChickenCraftConstants.CHICKEN_TYPE_DRAGON }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_CAVE,
				new ItemStack[] { new ItemStack(Blocks.MOSSY_COBBLESTONE) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_MINER,
				new ItemStack[] { new ItemStack(Items.COAL), new ItemStack(Items.IRON_INGOT),
						new ItemStack(Items.REDSTONE), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.DYE, 1, 4),
						new ItemStack(Items.DIAMOND), new ItemStack(Items.EMERALD) }));

		// Layer 4

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_DRAGON,
				new ItemStack[] { new ItemStack(Items.DRAGON_BREATH), new ItemStack(Blocks.DRAGON_EGG) }));

		ChickenTypeRegistry.registerType(new ChickenType(ChickenCraftConstants.CHICKEN_TYPE_ICE,
				new ItemStack[] { new ItemStack(Blocks.ICE), new ItemStack(Items.SNOWBALL) }));
	}
}
