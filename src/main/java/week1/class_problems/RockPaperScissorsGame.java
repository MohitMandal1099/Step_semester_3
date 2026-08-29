package week1.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        String p = playerMove.toLowerCase();
        String c = computerMove.toLowerCase();

        boolean playerWins =
                (p.equals("rock") && c.equals("scissors")) ||
                        (p.equals("paper") && c.equals("rock")) ||
                        (p.equals("scissors") && c.equals("paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");

        for (int round = 1; round <= playerMoves.length; round++) {
            String playerMove = playerMoves[round - 1];
            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(round + " | " + playerMove + " | " + computerMove + " | " + result);
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;

        System.out.println("\nFinal Summary (after " + playerMoves.length + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws +
                " | Win % = " + winPercentage + "%");
    }
}