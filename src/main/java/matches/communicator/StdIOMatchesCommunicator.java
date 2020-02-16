package matches.communicator;

import java.util.Scanner;

public class StdIOMatchesCommunicator implements MatchesCommunicator {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void logMatchesLeft(int matchesLeft) {
        System.out.println(matchesLeft + " matches left.");
    }

    @Override
    public void logAiMove(int aiPickedMatchesCount) {
        System.out.printf(" - AI picked %d matches.%n", aiPickedMatchesCount);
    }

    @Override
    public int getPlayerMove() {
        System.out.println(" - Player's move. Enter the number of matches to pick:");

        return scanner.nextInt();
    }

    @Override
    public void logBadPlayerMove() {
        System.out.println("Wrong number of matches!");
    }

    @Override
    public void logEndgame(boolean isAiWin) {
        System.out.printf("The %s looses as he's got the last match to pick.",
            isAiWin ? "Player" : "AI");
    }
}
