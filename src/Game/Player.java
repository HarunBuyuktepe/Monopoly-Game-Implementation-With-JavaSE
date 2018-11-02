package Game;

import java.util.Random;

public class Player {
	private int id;
	private String name;
	private int totalTour=0;
	private int position=0;
	private int money=0;
	private boolean inGame=false;
	
	
	public Player(int id,String name){//Our player is will created in here
		this.id=id;
		this.name=name;
	}
	
	
	/*-------------Walk Methods-------------*/
	public int getCurrentPosition() {//To get current pozition

		return position;
	}
	
	public void setPosition(int position) {//Game action

		this.position = position;
	}
	
	public void nextTurn() {//To update the tour number for the player
		totalTour++;
	}
	public int getTotalWalk() {//Number of tour which was player's tour
		return totalTour;
	}
	/*-------------Die Method-------------*/
	public int tossDie(){//Toss the die for the player
		Random die=new Random();
		int face=1+die.nextInt(6);
		return face;
	}
	/*-------------Money Methods-------------*/
	public int getMoney() {//To know the player's money
		return money;
	}
	
	public void addMoney(int amount) {//To add money to the player at any time
		money += amount;
	}
	
	public void substractMoney(int amount) {//To substract money from the player 
		money -= amount;
	}
	/*-------------Money and Winner Control Method-------------*/
	public boolean inGame() {
		if (money < 0){
			this.inGame=false;
		}
		else{
			this.inGame=true;
		}
		
		return inGame;
	}	
}
