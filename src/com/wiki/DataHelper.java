package com.wiki;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;

import org.json.JSONObject;

public class DataHelper {

	private static final String ENDPOINT = "https://en.wikipedia.org/w/api.php?";
	private static final String AMBASSADORS_PAGE_TITLE = "Ambassadors_of_the_United_States";
	private static final String FORMAT = "json";
	private static final String FORMAT_VERSION = "2";
	private static final String USER_AGENT = "";

	public static List<Ambassador> getAmbassadors() throws Exception {
		String response = sendQuery(AMBASSADORS_PAGE_TITLE);
		return JSONParser.parseAmbassadorsJson(new JSONObject(response));
	}

	private static String sendQuery(String pageTitle) throws Exception {
		String target = buildQueryString(pageTitle);
		HttpURLConnection conn = connectToTargetUrl(target);
		StringBuffer response = readConnection(conn);
		return response.toString();
	}

	private static HttpURLConnection connectToTargetUrl(String target)
			throws Exception {
		URL url = new URL(target);
		System.out.println("Attempting to access " + target);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		return conn;
	}

	private static StringBuffer readConnection(HttpURLConnection conn) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response;
	}

	private static String buildQueryString(String pageTitle) {
		StringBuilder target = new StringBuilder(ENDPOINT + "action=query");
		target.append("&titles=").append(pageTitle);
		target.append("&prop=revisions");
		target.append("&rvprop=content");
		target.append("&format=").append(FORMAT);
		target.append("&formatversion=").append(FORMAT_VERSION);
		return target.toString();
	}
}
