package controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import kong.unirest.*;

public class API_Handler {

	public static void main(String[] args) {
		
		Unirest.config().defaultBaseUrl("https://daten.stadt.sg.ch/api/records/1.0/search/");
		
//		HttpResponse response = Unirest.get("?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort={sortby}&facet=typ&facet=aufwand_ertrag&facet=kontostruktur&facet=ebene_1&facet=ebene_2&facet=ebene_3&facet=konto&facet=kontotitel")
//		.routeParam("sortby", "zeilennummer")
//		.asString();
//		System.out.println(response.getBody());
		System.out.println();
		String text = Unirest.get("https://daten.stadt.sg.ch/api/records/1.0/search/?dataset=budget-2021-stadt-stgallen-funktionale-gliederung-english-data&q=&sort=zeilennummer&facet=kontotitel&refine.ebene_1=4+health&refine.aufwand_ertrag=Expense&refine.ebene_2=45+Outpatient+nursing%2C+obstetrics")
		.asString().getBody();
		System.out.println(text);
		String searchWord = "budget_2021";
		Map<String, Integer> budgets = new HashMap<String,Integer>();
		
		for (int fromIndex = 0; fromIndex < text.length(); ++fromIndex) {
			int index = text.toLowerCase().indexOf(searchWord.toLowerCase(), fromIndex);
			if (index != -1) { // index exists -> word exists
				fromIndex += (index + searchWord.length()); // jump to index after word
				
				fromIndex += 3;
				if (fromIndex >= text.length())
					break;
				
				char ch = text.charAt(fromIndex);
				String number = "";
				while (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || 
						ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
					number += ch;
					++fromIndex;
					ch = text.charAt(fromIndex);
				}
				int value = 0;
				if (number.length() == 0)
					continue;
				value = Integer.parseInt(number);
				
				
				String searchWord2 = "kontotitel";
				for (; fromIndex < text.length(); ++fromIndex) {
					int index2 = text.toLowerCase().indexOf(searchWord2.toLowerCase(), fromIndex);
					if (index2 != -1) { // index exists -> word exists
						System.out.println("test");
						index2 += searchWord2.length();
						index2 += 4;
						String kontotitel = "";
						char ch2 = text.charAt(index2);
						while (ch2 != '"') {
							kontotitel += ch2;
							++index2;
							ch2 = text.charAt(index2);
						}
						budgets.put(kontotitel, value);
//						break;
					}
				}
			}
			
		}
		for (String kontotitel : budgets.keySet()) {
			System.out.println(budgets.get(kontotitel));
//			System.out.println("-----------------------");
//			System.out.println();
			System.out.println(kontotitel);
		}
	}
}
