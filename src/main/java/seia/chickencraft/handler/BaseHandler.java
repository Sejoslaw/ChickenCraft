package seia.chickencraft.handler;

import seia.chickencraft.core.ChickenCraft;

/**
 * Class which holds shared methods for all handlers.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class BaseHandler {
	protected final ChickenCraft chickenCraft;

	public BaseHandler(ChickenCraft chickenCraft) {
		this.chickenCraft = chickenCraft;
	}
}
