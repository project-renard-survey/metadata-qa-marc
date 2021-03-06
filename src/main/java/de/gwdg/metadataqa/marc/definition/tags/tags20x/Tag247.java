package de.gwdg.metadataqa.marc.definition.tags.tags20x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Former Title
 * http://www.loc.gov/marc/bibliographic/bd247.html
 */
public class Tag247 extends DataFieldDefinition {
	private static Tag247 uniqueInstance;

	private Tag247() {
		initialize();
		postCreation();
	}

	public static Tag247 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag247();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "247";
		label = "Former Title";
		bibframeTag = "VariantTitle";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd247.html";

		ind1 = new Indicator("Title added entry")
			.setCodes(
				"0", "No added entry",
				"1", "Added entry"
			)
			.setMqTag("titleAddedEntry");
		ind2 = new Indicator("Note controller")
			.setCodes(
				"0", "Display note",
				"1", "Do not display note"
			)
			.setMqTag("noteController");

		setSubfieldsWithCardinality(
			"a", "Title", "NR",
			"b", "Remainder of title", "NR",
			"f", "Date or sequential designation", "NR",
			"g", "Miscellaneous information", "R",
			"h", "Medium", "NR",
			"n", "Number of part/section of a work", "R",
			"p", "Name of part/section of a work", "R",
			"x", "International Standard Serial Number", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("a").setBibframeTag("mainTitle");
		getSubfield("b").setMqTag("remainder");
		getSubfield("f").setBibframeTag("date");
		getSubfield("g").setBibframeTag("qualifier").setMqTag("miscellaneous");
		getSubfield("h").setMqTag("medium");
		getSubfield("n").setBibframeTag("partNumber");
		getSubfield("p").setBibframeTag("partName");
		getSubfield("x").setMqTag("issn");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");

		setHistoricalSubfields(
			"d", "Designation of section/part/series (SE) [OBSOLETE, 1979]",
			"e", "Name of section/part/series (SE) [OBSOLETE, 1979]",
			"c", "Remainder of Title Page transcription [OBSOLETE] [CAN/MARC only]"
		);
	}
}
