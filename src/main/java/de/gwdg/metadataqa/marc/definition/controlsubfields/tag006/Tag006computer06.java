package de.gwdg.metadataqa.marc.definition.controlsubfields.tag006;

import de.gwdg.metadataqa.marc.Utils;
import de.gwdg.metadataqa.marc.definition.ControlSubfield;

/**
 * Form of item
 * https://www.loc.gov/marc/bibliographic/bd006.html
 */
public class Tag006computer06 extends ControlSubfield {
	private static Tag006computer06 uniqueInstance;

	private Tag006computer06() {
		initialize();
		extractValidCodes();
	}

	public static Tag006computer06 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag006computer06();
		return uniqueInstance;
	}

	private void initialize() {
		label = "Form of item";
		id = "tag006computer06";
		mqTag = "formOfItem";
		positionStart = 6;
		positionEnd = 7;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd006.html";
		codes = Utils.generateCodes(
			" ", "Unknown or not specified",
			"o", "Online",
			"q", "Direct electronic",
			"|", "No attempt to code"
		);
	}
}