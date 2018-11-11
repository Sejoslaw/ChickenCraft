package seia.chickencraft.genes;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import seia.chickencraft.api.core.ChickenCraftConstants;

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

	public String getTypeName() {
		return this.typeName;
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return new NBTTagString(ChickenCraftConstants.CHICKEN_TYPE_NORMAL);
	}
}
