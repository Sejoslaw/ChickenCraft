package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;

/**
 * Basic gene for
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
		return "ChickenCraft_ChickenType";
	}

	protected void updateChicken(EntityChicken entity) {
		this.newValue = this.getGeneValue(entity); // TODO: Change to add "Normal" if null.
	}
}
