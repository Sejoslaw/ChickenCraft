package seia.chickencraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.helper.DataHelper;

/**
 * Class which is responsible to handle all events connected with player.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class PlayerHandler extends BaseHandler {
	public PlayerHandler(ChickenCraft chickenCraft) {
		super(chickenCraft);
	}

	/**
	 * This method handles when player throws an egg.
	 */
	public void handlePlayerThrowEgg(EntityPlayer player, ItemStack eggStack) {
		World world = player.world;

		if (!player.capabilities.isCreativeMode) {
			eggStack.shrink(1);
		}

		world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_EGG_THROW,
				SoundCategory.PLAYERS, 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			EntityEgg egg = new EntityEgg(world, player);
			egg.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);

			DataHelper.writeGenes(eggStack, egg);

			for (IChickenGene gene : GeneRegistry.getGenes()) {
				gene.onPlayerThrowEgg(player, eggStack, egg);
			}

			world.spawnEntity(egg);
		}

		player.addStat(StatList.getObjectUseStats(Items.EGG));
	}
}
