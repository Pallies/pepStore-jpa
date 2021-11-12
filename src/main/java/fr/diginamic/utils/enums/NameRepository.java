package fr.diginamic.utils.enums;

import java.util.Arrays;

/**
 * The Enum NameRepository.
 * ref ClassName
 */
public enum NameRepository {

	/** The Cat. */
	Cat,
	/** The Fish. */
	Fish,
	/** The Animal. */
	Animal,
	/** The Pet store. */
	PetStore,
	/** The Product. */
	Product,
	/** The Address. */
	Address;

	/**
	 * Gets the class for name.
	 *
	 * @param name the name
	 * @return the class for name
	 */
	public static NameRepository getClassForName(String name) {
		String[] classSeparator = name.split("[.]");
		return NameRepository.valueOf(classSeparator[classSeparator.length - 1]);
	}

}
