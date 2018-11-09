package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;

/**
 * Basic gene for displaying mutation chance.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class MutationChanceGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Mutation chance (in %)";
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		String percentage = this.getNewRandomPercentage();
		this.newValue = new NBTTagString(percentage);
		this.writeNewDataToStack(eggStack);
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return new NBTTagString("50.00");
	}
}
