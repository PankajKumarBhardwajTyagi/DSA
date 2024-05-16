import beans.Player;
import beans.Score;
import beans.ScoreBoard;
import exceptions.ExcessPlayerException;
import exceptions.PlayerNotFoundException;
import service.PlayerService;

public class ScoreBoardTest {
	public static void main(String[] args) {
		try {
			PlayerService service = new Player(5);
			System.out.println("Player added with id " + service.addPlayer("Dilip", 50, "Batsman"));
			System.out.println("Player added with id " + service.addPlayer("Kiran", 50, "Bowler"));
			System.out.println("Player added with id " + service.addPlayer("Bharath", 40, "All-rounder"));
			System.out.println("Player added with id " + service.addPlayer("Nithin", 35, "Bowler"));
			System.out.println("Player added with id " + service.addPlayer("Rajesh", 42, "Batsman"));
			System.out.println();
			ScoreBoard scoreBoard = new ScoreBoard(5);
			System.out.println("Score added with id " + scoreBoard.addScore(new Score(service.getPlayerById(1), 50)));
			System.out.println("Score added with id " + scoreBoard.addScore(new Score(service.getPlayerById(2), 70)));
			System.out.println("Score added with id " + scoreBoard.addScore(new Score(service.getPlayerById(3), 100)));
			System.out.println("Score added with id " + scoreBoard.addScore(new Score(service.getPlayerById(4), 40)));
			System.out.println("Score added with id " + scoreBoard.addScore(new Score(service.getPlayerById(5), 20)));
			System.out.println();
			for(Score score : scoreBoard.getAllScores()) {
				if(score != null) System.out.println(score);
			}
			System.out.println();
			System.out.println("Score Removed: " + scoreBoard.removeScore(3));
			System.out.println();
			for(Score score : scoreBoard.getAllScores()) {
				if(score != null) System.out.println(score);
			}
			System.out.println();
		} catch (ExcessPlayerException epe) {
			System.err.println(epe.getMessage());
		} catch (PlayerNotFoundException pnfe) {
			System.err.println(pnfe.getMessage());
		}
	}
}