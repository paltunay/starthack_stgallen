package controller;

import java.util.Arrays;

import kong.unirest.*;

public class API_Handler {

	public static void main(String[] args) {
		
		Unirest.config().defaultBaseUrl("https://daten.stadt.sg.ch/api/records/1.0/search/");
		
		HttpResponse response = Unirest.get("?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort={sortby}&facet=typ&facet=aufwand_ertrag&facet=kontostruktur&facet=ebene_1&facet=ebene_2&facet=ebene_3&facet=konto&facet=kontotitel")
		.routeParam("sortby", "zeilennummer")
		.asString();
		System.out.println(response.getBody());
		System.out.println();
		String text = Unirest.get("https://daten.stadt.sg.ch/api/records/1.0/search/?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort=zeilennummer&facet=kontotitel&refine.ebene_1=4+health&refine.aufwand_ertrag=Expense&refine.ebene_2=45+Outpatient+nursing%2C+obstetrics")
		.asString().getBody();
		String searchWord = "budget_2021";
		for (int fromIndex = 0; fromIndex < text.length(); ++fromIndex) {
			if (text.toLowerCase().indexOf(searchWord.toLowerCase(), fromIndex) != -1) { // index exists -> word exists
				fromIndex += searchWord.length() - 1; // jump to index after word
			}
		}
	}
}
