package seia.chickencraft.handler;

import net.minecraft.entity.passive.EntityChicken;
import seia.chickencraft.core.ChickenCraft;

/**
 * Class which is responsible to handle all events connected with chickens.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class ChickenHandler extends BaseHandler {

	public ChickenHandler(ChickenCraft chickenCraft) {
		super(chickenCraft);
	}

	/**
	 * This method handles when chicken is updated (handle when to spawn egg or
	 * special item).
	 */
	public void handleChickenProduceItem(EntityChicken chicken) {
	}
}
