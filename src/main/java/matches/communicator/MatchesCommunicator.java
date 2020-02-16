package matches.communicator;

public interface MatchesCommunicator {

    void logMatchesLeft(int matchesLeft);

    void logAiMove(int aiPickedMatchesCount);

    int getPlayerMove();

    void logBadPlayerMove();

    void logEndgame(boolean isAiWin);
}
