package com.valentin;

import java.util.ArrayList;

public class Message {
	private final People author;
	private String title;
	private String content;
	private final ArrayList<People> likers;
	
	public Message(People author) {
		this.author = author;
		this.likers = new ArrayList<>();
	}
	
	public Message(People author, String title, String content) {
		this.author = author;
		this.title = title;
		this.content = content;
		this.likers = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void receiveLike(People people) {
		if(!likers.contains(people))
			this.likers.add(people);
	}
	
	public void display() {
		System.out.println(title);
		System.out.println("Par : " + author.getName());
		System.out.println(content);
		displayLikers();
	}
	
	public void displayLikers() {
		if(likers.size() == 0)
			return;
		System.out.print("Aimé par : ");
		for(People p : likers) {
			if(likers.get(likers.size()-1) != p)
				System.out.print(p.getName() + ",");
			else
				System.out.print(p.getName() + "\n");
		}
	}
	
}
