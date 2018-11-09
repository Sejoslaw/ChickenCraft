package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.registries.GeneRegistry;

/**
 * Gene which is responsible for mutating spawned egg.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class MutateEggGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Mutated Egg";
	}

	// TODO: Finish current gene.
	private boolean mutationOccurs(EntityChicken chicken) {
		IChickenGene mutationGene = GeneRegistry.GetGene(MutationChanceGene.class);
		String mutationValueString = mutationGene.getGeneValue(chicken).toString();
		double mutationValue = Double.parseDouble(mutationValueString);

		double randomizedValue = Double.parseDouble(this.getNewRandomPercentage());

		if (mutationValue > randomizedValue) {
			return true;
		}

		return false;
	}
}
