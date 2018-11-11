package seia.chickencraft.api.registries;

import java.util.HashMap;
import java.util.Map;

import seia.chickencraft.api.models.IChickenType;

/**
 * Registry which holds information about all chicken types and it's hierarchy.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class ChickenTypeRegistry {
	/**
	 * Holds information about all hierarchy relations.
	 */
	private static final Map<String, IChickenType> CHICKEN_TYPES = new HashMap<>();

	private ChickenTypeRegistry() {
	}

	/**
	 * Registers new model in current hierarchy.
	 */
	public static void registerType(IChickenType model) {
		CHICKEN_TYPES.put(model.getChickenTypeName(), model);
	}

	/**
	 * @return Returns chicken type by it's name.
	 */
	public static IChickenType getModel(String chickenTypeName) {
		return CHICKEN_TYPES.get(chickenTypeName);
	}
}
