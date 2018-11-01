package seia.chickencraft.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import seia.chickencraft.api.genes.IGene;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.helper.DataHelper;

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
		World world = egg.world;
		Random rand = new Random();

		if (!world.isRemote) {
			if (rand.nextInt(8) == 0) {
				// Prepare chicken
				EntityChicken chicken = new EntityChicken(world);
				chicken.setGrowingAge(-24000);
				chicken.setLocationAndAngles(egg.posX, egg.posY, egg.posZ, egg.rotationYaw, 0.0F);

				// Add genes to chicken
				for (IGene gene : GeneRegistry.getGenes()) {
					gene.updateEntity(chicken);
				}

				world.spawnEntity(chicken);
			}

			world.setEntityState(egg, (byte) 3);
			egg.setDead();
		}
	}
}
