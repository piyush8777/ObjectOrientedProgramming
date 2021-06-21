package com.bridgelabz.program;

import java.util.Random;

public class DeckofCards {
	Card cards[];
	String suits[]={"Club","Diamond", "Heart", "Spade"};
	String ranks[]={"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	public void DeckOfCards(){
		cards=initializeCards();
	}
	public void shuffle(Card[] cards){
		Random random=new Random();
		Card card;
		for(int i=0;i<52;i++){
			int index=random.nextInt(52);
			int index2=random.nextInt(52);
			card=cards[index];
			cards[index]=cards[index2];
			cards[index2]=card;
		}
	}
	public Card[] initializeCards(){
		Card cards[]=new Card[52];
		int cardIndex=0;
		for(int i=0;i<suits.length;i++){
			for(int j=0;j<ranks.length;j++){
				cards[cardIndex]=new Card(suits[i],ranks[j]);
				cardIndex++;
			}
		}
		return cards;
	}
	public void alotCards(Card players[][]){
		int playersIndex=0;
		shuffle(this.cards);
		for(int i=0;i<players.length;i++){
			for(int j=0;j<players[i].length;j++){
				players[i][j]=cards[playersIndex];
				playersIndex++;
			}
		}
	}
	public void display(Card players[][]){
		for(int i=0;i<players.length;i++){
			System.out.print("Player"+(i+1)+" Cards: ");
			for(int j=0;j<players[i].length;j++){
				System.out.print(players[i][j].suit+"-"+players[i][j].rank+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		DeckofCards deckOfCards=new DeckofCards();
		Card players[][]=new Card[4][9];
		deckOfCards.alotCards(players);
		System.out.println("After Shuffle");
		for(int i=0;i<deckOfCards.cards.length;i++){
			System.out.print(deckOfCards.cards[i].suit+"-"+deckOfCards.cards[i].rank+" ");
		}
		System.out.println();
		System.out.println("Cards received by players");
		deckOfCards.display(players);
	}
}
