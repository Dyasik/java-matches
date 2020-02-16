package matches.ai;

public class AlwaysWinningMatchesAI implements MatchesAI {

    @Override
    public int pickMatches(int matchesLeft, int maxMatchesToPick) {

        int matchesToPick = 1;

        for (; matchesToPick <= maxMatchesToPick; matchesToPick++) {
            if ((matchesLeft - matchesToPick) % (maxMatchesToPick + 1) == 1) {
                break;
            }
            if (matchesToPick == maxMatchesToPick) {
                break;
            }
        }

        return matchesToPick;
    }

}
