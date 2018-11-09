package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;

/**
 * Gene which is responsible for speeding up egg production by chickens.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class DecreaseEggSpawningTicksGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Decrease Egg Spawning Ticks";
	}

	public void updateChicken(EntityChicken chicken) {
		NBTBase geneValueBase = this.getGeneValue(chicken);
		String geneValueString = ((NBTTagString) geneValueBase).getString();
		int geneValue = Integer.parseInt(geneValueString);
		chicken.timeUntilNextEgg -= geneValue;
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		String percentValue = String.valueOf(this.rand.nextInt(100));
		this.newValue = new NBTTagString(percentValue);
		this.writeNewDataToStack(eggStack);
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return new NBTTagString("0");
	}
}