package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import seia.chickencraft.helper.SoundHelper;

/**
 * Gene which is responsible for spawning extra-item. Current gene holds
 * information about ItemStack which will be extra-dropped by chicken.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class ItemProduceGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Item Produce";
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		NBTBase geneValueBase = this.getGeneValue(chicken);

		if (geneValueBase == null) {
			return;
		}

		ItemStack producedItemStack = new ItemStack((NBTTagCompound) geneValueBase);
		SoundHelper.playChickenDropSound(chicken);
		chicken.entityDropItem(producedItemStack, 0);
	}
}
