package com.wiki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
	
	private static final String EMPTY_STRING = "";
	private static final String NEW_ROW = "|-";
	private static final String NEW_COLUMN = "||";
	
	public static List<Ambassador> parseAmbassadorsJson(JSONObject json) 
			throws Exception {
		JSONArray pages = json.getJSONObject("query").getJSONArray("pages");
		JSONArray revisions = pages.getJSONObject(0).getJSONArray("revisions");
		String currentAmbTable = extractCleanAmbassadorTable(revisions);
		List<Ambassador> ambassadorList = parseTable(currentAmbTable);
		return ambassadorList;
	}

	private static String extractCleanAmbassadorTable(JSONArray revisions) throws Exception {
		String content = revisions.getJSONObject(0).getString("content");
		content = content.replace("[[", EMPTY_STRING).replace("]]", EMPTY_STRING);
		content = content.replace("{{", EMPTY_STRING).replace("}}", EMPTY_STRING);
		content = content.replace("flag", EMPTY_STRING);
		content = content.replace("small|", EMPTY_STRING);
		content = content.replace("|List", EMPTY_STRING);
		content = content.replace("||", "|| ");
		int listStart = content.indexOf("==Current U.S. ambassadors==");
		int listEnd = content.indexOf("==See also==");
		String currentAmbTable = content.substring(listStart, listEnd);
		return currentAmbTable;
	}

	private static List<Ambassador> parseTable(String currentAmbTable) {
		List<Ambassador> ambassadorList = new ArrayList<Ambassador>();
		Scanner rowScan = new Scanner(currentAmbTable);
		rowScan.useDelimiter(NEW_ROW);
		while (rowScan.hasNextLine()) {
			String row = rowScan.nextLine();
			if (!NEW_ROW.equals(row) && row.startsWith(NEW_COLUMN)) {
				Ambassador ambassador = setAmbassadorFromRow(row);
				ambassadorList.add(ambassador);
			}
		}
		rowScan.close();
		return ambassadorList;
	}

	private static Ambassador setAmbassadorFromRow(String row) {
		Ambassador ambassador = new Ambassador();
		String[] rowSplit = row.split(" \\|\\| ");
		for (String piece : rowSplit) {
//			if (piece.matches(TITLE_PATTERN)) {
//				
//			} else if (piece.matches(LOCATION_PATTERN)) {
//				
//			} else if (piece.matches(WEBSITE_PATTERN)) {
//				
//			}
		}
//		if (rowSplit.length == 5) {
//			ambassador.setCountry(rowSplit[0].substring(3));
//			ambassador.setTitle(rowSplit[1]);
//			ambassador.setName(rowSplit[2]);
//			if (rowSplit[3].split("\\|").length > 1) {
//				ambassador.setLocation(rowSplit[3].split("\\|")[0]);
//				ambassador.setWebsiteUrl(rowSplit[3].split("\\|")[1]);
//			}
//			ambassador.setConfirmationDate(rowSplit[4]);
//		} else {
//			ambassador.setFullLocation(row);
//		}
		return ambassador;
	}
}
