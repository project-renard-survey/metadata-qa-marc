package de.gwdg.metadataqa.marc.definition.tags.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.parser.RecordControlNumberParser;

/**
 * Musical Incipits Information
 * http://www.loc.gov/marc/bibliographic/bd031.html
 */
public class Tag035 extends DataFieldDefinition {

	private static Tag035 uniqueInstance;

	private Tag035() {
		initialize();
	}

	public static Tag035 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag035();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "035";
		label = "System Control Number";
		bibframeTag = "SystemControlNumber";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator();
		ind2 = new Indicator();
		setSubfieldsWithCardinality(
			"a", "System control number", "NR",
			"z", "Canceled/invalid control number", "R",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);
		getSubfield("a").setContentParser(RecordControlNumberParser.getInstance());
		getSubfield("a").setBibframeTag("rdf:value");
	}
}