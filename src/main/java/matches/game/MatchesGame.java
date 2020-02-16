package matches.game;

import matches.ai.MatchesAI;
import matches.communicator.MatchesCommunicator;

public class MatchesGame {

    private final MatchesAI ai;
    private final MatchesCommunicator communicator;
    private final int startMatchesCount;
    private final int maxMatchesToPick;

    public MatchesGame(MatchesAI ai, MatchesCommunicator communicator, int startMatchesCount, int maxMatchesToPick) {
        this.ai = ai;
        this.communicator = communicator;
        this.startMatchesCount = startMatchesCount;
        this.maxMatchesToPick = maxMatchesToPick;
    }

    public void run() {
        int matchesCount = startMatchesCount;
        boolean isAiMove = true;

        while (matchesCount > 1) {
            communicator.logMatchesLeft(matchesCount);

            if (isAiMove) {
                int aiPickedMatchesCount = ai.pickMatches(matchesCount, maxMatchesToPick);

                communicator.logAiMove(aiPickedMatchesCount);
                matchesCount -= aiPickedMatchesCount;
            } else {
                int playerPickedMatchesCount = 0;
                boolean isPlayerPickValid = false;

                while (!isPlayerPickValid) {
                    playerPickedMatchesCount = communicator.getPlayerMove();

                    if (playerPickedMatchesCount < 1 || playerPickedMatchesCount > maxMatchesToPick) {
                        communicator.logBadPlayerMove();
                    } else {
                        isPlayerPickValid = true;
                    }
                }

                matchesCount -= playerPickedMatchesCount;
            }

            isAiMove = !isAiMove;
        }

        communicator.logEndgame(!isAiMove);
    }
}
