package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Basic gene for displaying Parent / Chicken type.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class ChickenTypeGene extends BaseChickenGene {

	private String typeName;

	public ChickenTypeGene(String typeName) {
		this.typeName = typeName;
	}

	public String getDisplayName() {
		return this.typeName + " Type";
	}

	public String getNbtTag() {
		return this.buildNbtTag(this.typeName);
	}

	public String getGeneValue(NBTTagCompound tag) {
		String geneValue = super.getGeneValue(tag);
		if (geneValue == null) {
			return "Normal";
		} else {
			return geneValue;
		}
	}

	protected void updateChicken(EntityChicken entity) {
		this.newValue = this.getGeneValue(entity);
	}
}
