package de.gwdg.metadataqa.marc.definition.tags.tags76x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;

/**
 * Other Edition Entry
 * http://www.loc.gov/marc/bibliographic/bd775.html
 */
public class Tag775 extends DataFieldDefinition {

	private static Tag775 uniqueInstance;

	private Tag775() {
		initialize();
		postCreation();
	}

	public static Tag775 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag775();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "775";
		label = "Other Edition Entry";
		bibframeTag = "OtherEdition";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd775.html";

		ind1 = new Indicator("Note controller")
			.setCodes(
				"0", "Display note",
				"1", "Do not display note"
			)
			.setMqTag("noteController");
		ind2 = new Indicator("Display constant controller")
			.setCodes(
				" ", "Other edition available",
				"8", "No display constant generated"
			)
			.setHistoricalCodes(
				"0", "Entry not the same",
				"1", "Entry is the same as title",
				"2", "Entry is the same as main entry and title"
			)
			.setMqTag("displayConstant");

		setSubfieldsWithCardinality(
			"a", "Main entry heading", "NR",
			"b", "Edition", "NR",
			"c", "Qualifying information", "NR",
			"d", "Place, publisher, and date of publication", "NR",
			"e", "Language code", "NR",
			"f", "Country code", "NR",
			"g", "Related parts", "R",
			"h", "Physical description", "NR",
			"i", "Relationship information", "R",
			"k", "Series data for related item", "R",
			"m", "Material-specific details", "NR",
			"n", "Note", "R",
			"o", "Other item identifier", "R",
			"r", "Report number", "R",
			"s", "Uniform title", "NR",
			"t", "Title", "NR",
			"u", "Standard Technical Report Number", "NR",
			"w", "Record control number", "R",
			"x", "International Standard Serial Number", "NR",
			"y", "CODEN designation", "NR",
			"z", "International Standard Book Number", "R",
			"4", "Relationship", "R",
			"6", "Linkage", "NR",
			"7", "Control subfield", "NR",
			"8", "Field link and sequence number", "R"
		);

		// TODO: this requires position parser!
		// see http://www.loc.gov/marc/bibliographic/bd76x78x.html
		getSubfield("7").setCodes(
			"0", "Type of main entry heading",
			"1", "Form of name",
			"2", "Type of record",
			"3", "Bibliographic level"
		);
		getSubfield("4").setCodeList(RelatorCodes.getInstance());

		getSubfield("a").setBibframeTag("rdfs:label").setMqTag("rdf:value");
		getSubfield("b").setBibframeTag("editionStatement");
		getSubfield("c").setBibframeTag("qualifier");
		getSubfield("d").setBibframeTag("provisionActivityStatement");
		getSubfield("e").setBibframeTag("language");
		getSubfield("f").setBibframeTag("place");
		getSubfield("g").setBibframeTag("part");
		getSubfield("h").setBibframeTag("extent");
		getSubfield("i").setBibframeTag("relation");
		getSubfield("k").setBibframeTag("seriesStatement");
		getSubfield("m").setBibframeTag("note").setMqTag("materialSpecificDetails");
		getSubfield("n").setBibframeTag("note");
		getSubfield("o").setMqTag("otherItemIdentifier");
		getSubfield("r").setMqTag("reportNumber");
		getSubfield("s").setBibframeTag("title").setMqTag("uniformTitle");
		getSubfield("t").setBibframeTag("title");
		getSubfield("u").setBibframeTag("strn");
		getSubfield("w").setMqTag("recordControlNumber");
		getSubfield("x").setBibframeTag("issn");
		getSubfield("y").setBibframeTag("coden");
		getSubfield("z").setBibframeTag("isbn");
		getSubfield("4").setMqTag("relationship");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("7").setMqTag("controlSubfield");
		getSubfield("8").setMqTag("fieldLink");
	}
}
