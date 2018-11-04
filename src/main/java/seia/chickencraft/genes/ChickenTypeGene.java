package seia.chickencraft.genes;

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

	protected String getDefaultGeneValue(NBTTagCompound tag) {
		return "Normal";
	}
}
