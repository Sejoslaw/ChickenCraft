package seia.chickencraft.handler;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import seia.chickencraft.core.ChickenCraft;

/**
 * Class which is responsible to handle all events connected with showing egg
 * tooltips / genetics metadata.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class TooltipHandler extends BaseHandler {

	public TooltipHandler(ChickenCraft chickenCraft) {
		super(chickenCraft);
	}

	/**
	 * This method handles showing egg item tooltips with all genes and metadata.
	 */
	public void handleShowEggTooltip(EntityPlayer player, ItemStack eggStack, List<String> tooltips) {
	}

	/**
	 * This method handles showing chicken details with all genes and metadata.
	 */
	public void handleShowChickenDetails(EntityPlayer player, EntityChicken clickedEntity) {
	}
}
