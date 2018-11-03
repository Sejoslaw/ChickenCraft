package seia.chickencraft.api.registries;

import java.util.Collection;
import java.util.HashSet;

import seia.chickencraft.api.genes.IChickenGene;

/**
 * Registry which holds information about all genes.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class GeneRegistry {

	private static Collection<IChickenGene> GENES = new HashSet<IChickenGene>();

	private GeneRegistry() {
	}

	/**
	 * Adds new gene to registry.
	 */
	public static void registerGene(IChickenGene gene) {
		GENES.add(gene);
	}

	/**
	 * @return Returns a COPY of all currently registered genes.
	 */
	public static Collection<IChickenGene> getGenes() {
		Collection<IChickenGene> set = new HashSet<IChickenGene>();
		set.addAll(GENES);
		return set;
	}
}
