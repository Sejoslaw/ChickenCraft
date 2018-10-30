package seia.chickencraft.modloader.forge;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import seia.chickencraft.core.ChickenCraft;

/**
 * Core class for Forge mod.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
@Mod(modid = ChickenCraft.MODID, name = ChickenCraft.NAME, version = ChickenCraft.VERSION)
public class ChickenCraftForgeMod extends ChickenCraft {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.registerBasicGenes();
		this.registerModEvents();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	private void registerModEvents() {
		MinecraftForge.EVENT_BUS.register(new ChickenCraftForgeEvents(this));
	}
}