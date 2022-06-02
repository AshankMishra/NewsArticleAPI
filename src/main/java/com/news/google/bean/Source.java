package com.news.google.bean;

public class Source {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", name=" + name + "]";
	}

}
