package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import seia.chickencraft.api.core.ChickenCraftConstants;

/**
 * Basic gene for displaying current chicken generation.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class GenerationGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Generation";
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		NBTBase geneValueBase = this.getGeneValue(chicken);
		String geneValue = ((NBTTagString) geneValueBase).getString();
		long value = Long.parseLong(geneValue);
		value += 1;
		this.newValue = new NBTTagString(String.valueOf(value));
		this.writeNewDataToStack(eggStack);
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return new NBTTagString(ChickenCraftConstants.GENE_GENERATION);
	}
}