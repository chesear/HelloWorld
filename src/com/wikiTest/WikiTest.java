package com.wikiTest;

import java.util.List;

import com.wiki.Ambassador;
import com.wiki.DataHelper;

public class WikiTest {
	
	public static String getTestString() {
		return " and a happy new year!";
	}
	
	public static String getWikiString() {
		try {
			List<Ambassador> ambassadors = DataHelper.getAmbassadors();
			return getAmbassadorsListAsHtmlString(ambassadors);
		} catch (Exception e) {
			System.out.println(e);
			return "Oh no!  Something happened! <p>" + e;
		}
	}
	
	private static String getAmbassadorsListAsHtmlString(List<Ambassador> ambassadors) {
		StringBuffer htmlResponse = new StringBuffer();
		for (Ambassador ambassador : ambassadors) {
			htmlResponse.append(ambassador.getHtmlEntry());
			htmlResponse.append("</br>");
		}
		return htmlResponse.toString();
	}
}
