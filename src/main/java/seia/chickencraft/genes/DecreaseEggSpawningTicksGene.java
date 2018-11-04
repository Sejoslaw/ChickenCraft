package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
		String geneValueString = this.getGeneValue(chicken);
		int geneValue = Integer.parseInt(geneValueString);
		chicken.timeUntilNextEgg -= geneValue;
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		this.newValue = String.valueOf(this.rand.nextInt(100));
		this.writeNewDataToStack(eggStack);
	}

	protected String getDefaultGeneValue(NBTTagCompound tag) {
		return "0";
	}
}