package seia.chickencraft.handler;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import seia.chickencraft.api.genes.IChickenGene;
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
		if (!world.isRemote) {
			if (this.rand.nextInt(8) == 0) {
				this.spawnChicken(egg, world);
			}
			world.setEntityState(egg, (byte) 3);
			egg.setDead();
		}
	}

	private void spawnChicken(EntityEgg egg, World world) {
		EntityChicken chicken = new EntityChicken(world);

		if (ChickenCraft.DEBUG) {
			chicken.setGrowingAge(24000); // Grow chicken
		} else {
			chicken.setGrowingAge(-24000); // Small chicken
		}

		chicken.setLocationAndAngles(egg.posX, egg.posY, egg.posZ, egg.rotationYaw, 0.0F);

		DataHelper.writeGenes(egg, chicken);

		for (IChickenGene gene : GeneRegistry.getGenes()) {
			gene.onChickenSpawnFromEgg(egg, chicken);
		}

		world.spawnEntity(chicken);
	}
}
