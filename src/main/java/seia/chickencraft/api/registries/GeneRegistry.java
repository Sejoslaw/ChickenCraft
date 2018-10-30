package seia.chickencraft.api.registries;

import java.util.Collection;
import java.util.HashSet;

import seia.chickencraft.api.genes.IGene;

/**
 * Registry which holds information about all genes.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class GeneRegistry {

	private static Collection<IGene> GENES = new HashSet<IGene>();

	private GeneRegistry() {
	}

	/**
	 * Adds new gene to registry.
	 */
	public static void registerGene(IGene gene) {
		GENES.add(gene);
	}

	/**
	 * @return Returns a COPY of all currently registered genes.
	 */
	public static Collection<IGene> getGenes() {
		Collection<IGene> set = new HashSet<IGene>();
		set.addAll(GENES);
		return set;
	}
}
