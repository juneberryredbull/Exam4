// Eddie Hart
// May 2nd, 2024
// CSC 1060

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiceGame {

    // decideWinner method. kind of a pain in the ass to figure it out, but she works.
    public static ArrayList<Integer> decideWinner(ArrayList<Player> p) {
        int maxNumber = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            int pValue = p.get(i).getDie().getValue();
            if (pValue > maxNumber) {
                maxNumber = pValue;
            }
        }
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getDie().getValue() == maxNumber) {
                index.add(i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int dieSides = 0;
        int playerNum = 0;

        // here we get the number of sides of die and number of players
        try {
            System.out.println("Enter number of sides for the die: ");
            dieSides = input.nextInt();
            System.out.println("Enter number of players: ");
            playerNum = input.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input Mismatch Exception. Please Input An Integer (Whole Number).");
            System.exit(0);
        }

        // for loop depending on player amount. asks for their names and adds them to arraylist
        for (int i = 0; i < playerNum; i++) {
            System.out.println("Enter the name for player " + (i + 1) + ":");
            players.add(new Player(input.next(), new Die(dieSides)));
        }

        try {
            FileWriter gameOutput = new FileWriter("DiceGameOutput.txt");

            // for loop that rolls the die for each player and prints what they rolled
            for (Player player : players) {
                player.getDie().roll();
                System.out.println(player.toString());
                gameOutput.write(player.toString() + "\n");
            }

            // block of code that decides winner or tie. its kind of ugly but it works so whateva.
            if (decideWinner(players).size() > 1) {
                String winnerNames = "";
                for (int i = 0; i < decideWinner(players).size(); i++) {
                    winnerNames += players.get(decideWinner(players).get(i)).getName() + " and ";
                }
                winnerNames = winnerNames.substring(0, winnerNames.length() - 5);
                System.out.println(winnerNames + " tied.");
                gameOutput.write(winnerNames + " tied.");
                gameOutput.close();
            } else {
                System.out.println(players.get(decideWinner(players).getFirst()).getName() + " won the game!");
                gameOutput.write(players.get(decideWinner(players).getFirst()).getName() + " won the game!");
                gameOutput.close();
            }
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
        System.out.println("\nGame results have also been printed to DiceGameOutput.txt");
    }
}