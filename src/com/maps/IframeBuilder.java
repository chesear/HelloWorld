package com.maps;

public class IframeBuilder {
	private static String width = "800";
	private static String height = "500";
	private static String baseUrl = "https://www.google.com/maps/embed/v1/";
	private static int zoom = 5;
	private static String key = "AIzaSyBJ7LMpz_qI7C0on4EM46tH1kvjGWB2vnc";
	
	private static final String iFrameTemplate = "iframe $width $height $src iframe";
	
	private enum Keyword {
		PLACE("place"),
		SEARCH("search"),
		DIRECTIONS("directions"),
		STREETVIEW("streetview"),
		VIEW("view");
		
		private String word;
		
		private Keyword(String setFunnel) {
			word = setFunnel;
		}
	}

	public static String sayHi() {
		return "Hi!";
	}
	
	public static String buildIFrame() {
		String iFrame = iFrameTemplate;
//		iFrame = iFrame.replaceAll("$width", "width='" + width + "'");
//		iFrame = iFrame.replaceAll("$height", "height='" + height + "'");
//		iFrame = iFrame.replaceAll("$src", "src='" + buildSrcUrl() + "'");
		iFrame = iFrame.replaceAll("$width", "");
		iFrame = iFrame.replaceAll("$height", "");
		iFrame = iFrame.replaceAll("$src", "");
		System.out.println(iFrame);
		return iFrame;
	}
	
	private static String buildSrcUrl() {
		String searchTerm = "Sterling%20Heights%20MI";
		String srcUrl = baseUrl + getKeywordAndParams(searchTerm);
		srcUrl += "&zoom=" + zoom;
		srcUrl += "&key=" + key;
		return srcUrl;
	}
	
	private static String getKeywordAndParams(String searchTerm) {
		return Keyword.SEARCH.word + "?q=" + searchTerm;
	}
}
