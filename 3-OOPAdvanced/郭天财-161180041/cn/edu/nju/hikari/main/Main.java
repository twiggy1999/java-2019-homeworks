package main;

import creature.*;
import ground.*;
import command.Command;

public class Main{
    static Ground ground = new Ground();
    static Grandpa grandpa = new Grandpa();
    static ScorpionField BadGuys = new ScorpionField();
    public static void main(String[] args){
        
        grandpa.giveCommand(Command.RANDOM_SNAKE);
        Ground.printToScreen();
        grandpa.giveCommand(Command.SNAKE);
        BadGuys.wing();
        Ground.printToScreen();
    }
}