package com.valentin;

import java.util.ArrayList;

public class People {
	private final String name;
	private final ArrayList<Message> messages;
	private final  ArrayList<People> followers;
	
	public People(String name) {
		this.name = name;
		this.messages = new ArrayList<Message>();
		this.followers = new ArrayList<People>();
	}
	
	public String getName() {
		return name;
	}
	
	public void follow(People people) {
		people.addFollower(this);
	}
	
	public void like(Message message) {
		message.receiveLike(this);
	}
	
	public void display() {
		System.out.println("Page de " + this.getName() + "\n");
		for(Message message : messages) {
			message.display();
			System.out.println("-----\n");
		}
	}
	
	public void post(String title, String content) {
		Message message = new Message(this, title, content);
		this.messages.add(message);
		broadcast(message);
	}
	
	public void post(Message message) {
		this.messages.add(message);
		broadcast(message);
	}
	
	public Message lastPost() {
		if(this.messages.size() > 0)
			return this.messages.get(this.messages.size()-1);
		else 
			return null;
	}
	
	public void receive(Message message) {
		this.messages.add(message);
	}
	
	
	private void addFollower(People people) {
		if(!this.followers.contains(people))
			this.followers.add(people);
	}
	
	private void broadcast(Message message) {
		for(People people : followers) {
			people.receive(message);
		}
	}

}
