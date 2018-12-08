package Monopoly.Player;

public class Position {
    int position;
    public Position(){

    }
    public int getCurrentPosition() {//To get current position
        return position;
    }

    public void setPosition(int position) {   //Monopoly action
        this.position = position;
    }
}
