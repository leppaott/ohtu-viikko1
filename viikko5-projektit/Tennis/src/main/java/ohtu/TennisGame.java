package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    private String scoreToString(int points) {
        String score;
        switch (points) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private String deltaScoreToString(int delta) {
        String score;
        if (delta == 1) {
            score = "Advantage player1";
        } else if (delta == -1) {
            score = "Advantage player2";
        } else if (delta >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
    
    private boolean scoreOver(int a, int b) {
        return a >= 4 || b >= 4;
    }
    
    private boolean isTie(int a, int b) {
        return a == b;
    }

    public String getScore() {
        if (isTie(m_score1, m_score2)) {
            String score = scoreToString(m_score1);
            if (score.equals("Deuce")) return score;
            return score + "-All";
        } else if (scoreOver(m_score1, m_score2)) {
            return deltaScoreToString(m_score1 - m_score2);
        } else {
            return scoreToString(m_score1) + "-" + scoreToString(m_score2);
        }
    }
}
