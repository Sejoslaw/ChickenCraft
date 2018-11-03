package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Basic gene for displaying current chicken generation.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class GenerationGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Generation";
	}

	public String getGeneValue(NBTTagCompound tag) {
		String geneValue = super.getGeneValue(tag);
		if (geneValue == null) {
			return "0";
		} else {
			return geneValue;
		}
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		String geneValue = this.getGeneValue(chicken);
		long value = Long.parseLong(geneValue);
		value += 1;
		this.newValue = String.valueOf(value);
		this.writeNewDataToStack(eggStack);
	}
}