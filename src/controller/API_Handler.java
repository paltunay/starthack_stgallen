package controller;

import java.util.Arrays;

import kong.unirest.*;

public class API_Handler {

	public static void main(String[] args) {
		
		Unirest.config().defaultBaseUrl("https://daten.stadt.sg.ch/api/records/1.0/search/");
		
//		HttpResponse response = Unirest.get("?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort={sortby}&facet=typ&facet=aufwand_ertrag&facet=kontostruktur&facet=ebene_1&facet=ebene_2&facet=ebene_3&facet=konto&facet=kontotitel")
//		.routeParam("sortby", "zeilennummer")
//		.asString();
		HttpResponse response = Unirest.get("?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort=zeilennummer&facet=typ&facet=aufwand_ertrag&facet=kontostruktur&facet=ebene_1&facet=konto&facet=kontotitel")
		.asString();
		
		System.out.println(response.getBody());
	}
}
