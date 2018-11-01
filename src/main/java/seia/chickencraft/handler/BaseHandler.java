package seia.chickencraft.handler;

import java.util.Random;

import seia.chickencraft.core.ChickenCraft;

/**
 * Class which holds shared methods for all handlers.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class BaseHandler {
	protected final ChickenCraft chickenCraft;
	protected final Random rand;

	public BaseHandler(ChickenCraft chickenCraft) {
		this.chickenCraft = chickenCraft;
		this.rand = new Random();
	}
}
