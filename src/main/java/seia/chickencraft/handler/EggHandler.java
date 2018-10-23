package seia.chickencraft.handler;

import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.util.math.RayTraceResult;
import seia.chickencraft.core.ChickenCraft;

/**
 * Class which is responsible to handle all events connected with eggs.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class EggHandler extends BaseHandler {

	public EggHandler(ChickenCraft chickenCraft) {
		super(chickenCraft);
	}

	/**
	 * This method handles when egg hit anything (spawns new chicken with
	 * appropriate custom metadata).
	 */
	public void handleEggHitGround(EntityEgg egg, RayTraceResult impactedThing) {
	}
}
