package seia.chickencraft.helper;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.registries.GeneRegistry;

/**
 * Helper which is used to retrieve metadata from objects.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class DataHelper {
	private DataHelper() {
	}

	public static NBTTagCompound getEntityData(Entity entity) { // Wrapper for Forge added method.
		return entity.getEntityData();
	}

	public static NBTTagCompound getItemStackData(ItemStack stack) { // Wrapper for Forge added method.
		return stack.getTagCompound();
	}

	public static void writeGenes(ItemStack stackSource, Entity entityDestination) {
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			String geneKey = gene.getNbtTag();
			NBTBase geneValue = gene.getGeneValue(stackSource);
			getEntityData(entityDestination).setTag(geneKey, geneValue);
		}
	}

	public static void writeGenes(Entity entitySource, Entity entityDestination) {
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			String geneKey = gene.getNbtTag();
			NBTBase geneValue = gene.getGeneValue(entitySource);
			getEntityData(entityDestination).setTag(geneKey, geneValue);
		}
	}

	public static void writeGenes(Entity entitySource, ItemStack stackDestination) {
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			String geneKey = gene.getNbtTag();
			NBTBase geneValue = gene.getGeneValue(entitySource);
			getItemStackData(stackDestination).setTag(geneKey, geneValue);
		}
	}
}
