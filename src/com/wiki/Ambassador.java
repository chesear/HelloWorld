package com.wiki;

public class Ambassador {

	private String title;
	private String location;
	private String websiteUrl;
	private String name;
	private String fullLocation;
	private String confirmationDate;
	private String country;
	
	public String getHtmlEntry() {
		StringBuffer html = new StringBuffer();
		html.append("<ul>");
		addListItem(html, "Title", title);
		addListItem(html, "Location", location);
		addListItem(html, "Website", transformWebsiteToHyperlink(websiteUrl));
		addListItem(html, "Name", name);
		addListItem(html, "Full Location", fullLocation);
		addListItem(html, "Date of Confirmation", confirmationDate);
		addListItem(html, "Country", country);
		html.append("</ul>");
		return html.toString();
	}

	private void addListItem(StringBuffer html, String label, String value) {
		html.append("<li>");
		html.append(label + ": " + value);
		html.append("</li>");
	}

	private String transformWebsiteToHyperlink(String labelAndUrl) {
		if (null != labelAndUrl && !"".equals(labelAndUrl) && 
				labelAndUrl.matches("(.+ )+?\\[.+\\]")) {
			String[] labelAndUrlSplit = labelAndUrl.split("\\[");
			String label = labelAndUrlSplit[0];
			String url = labelAndUrlSplit[1].substring(0, labelAndUrlSplit[1].length() - 1);
			String link = "<a href='" + url + "'>" + label + "</a>";
			return link;
		}
		return labelAndUrl;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullLocation() {
		return fullLocation;
	}

	public void setFullLocation(String fullLocation) {
		this.fullLocation = fullLocation;
	}

	public String getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(String confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
