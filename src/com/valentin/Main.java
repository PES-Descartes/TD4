package com.valentin;

public class Main {

	public static void main(String[] args) {
		People alice = new People("Alice");
		People bob = new People("Bob");
		People carol = new People("Carol");
		
		Message message1 = new Message(alice);
		message1.setTitle("Mon premier message");
		message1.setContent("bonjour à tous !");
		alice.post(message1);
		
		bob.follow(alice);
		carol.like(alice.lastPost());
		
		alice.post("Mon second message","je vous aime.");
		bob.like(alice.lastPost());
		carol.like(alice.lastPost());
		bob.post("test test", "test");
		alice.post("À propos de Bob", "quel boulet celui-là.");
		carol.like(alice.lastPost());
		bob.post("Réponse à Alice", "t'as un problème???");
		bob.display();

	}

}
