package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Basic gene for displaying mutation chance.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class MutationChanceGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Mutation chance (in %)";
	}

	public String getGeneValue(NBTTagCompound tag) {
		String geneValue = super.getGeneValue(tag);
		if (geneValue == null) {
			return "50.00";
		} else {
			return geneValue;
		}
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		this.newValue = this.getNewRandomPercentage();
		this.writeNewDataToStack(eggStack);
	}

	public String getNewRandomPercentage() {
		double percent = this.rand.nextDouble();
		percent *= 100;

		String percentValue = String.valueOf(percent);
		if (percent < 10) {
			percentValue = percentValue.substring(0, 4);
		} else {
			percentValue = percentValue.substring(0, 5);
		}

		return percentValue;
	}
}
