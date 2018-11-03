package seia.chickencraft.handler;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.helper.DataHelper;

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
		this.updateEntity(chicken);
		this.spawnEggWithGenes(chicken);
	}

	private void updateEntity(EntityChicken chicken) {
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			gene.updateChicken(chicken);
		}
	}

	private void spawnEggWithGenes(EntityChicken chicken) {
		World world = chicken.world;

		if (ChickenCraft.DEBUG) {
			chicken.timeUntilNextEgg -= 100; // Chicken will drop eggs faster
		}

		if (!world.isRemote && !chicken.isChild() && !chicken.isChickenJockey() && --chicken.timeUntilNextEgg <= 0) {
			chicken.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.dropEgg(chicken);
			chicken.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		}
	}

	private void dropEgg(EntityChicken chicken) {
		ItemStack stack = this.getEggWithDataStack(chicken);
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			gene.onChickenProduceEgg(chicken, stack);
		}
		chicken.entityDropItem(stack, 0);
	}

	private ItemStack getEggWithDataStack(EntityChicken chicken) {
		ItemStack stack = new ItemStack(Items.EGG);
		stack.setStackDisplayName("Mystery Egg");
		DataHelper.writeGenes(chicken, stack);
		return stack;
	}
}
