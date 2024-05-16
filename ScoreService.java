package service;

import beans.Player;
import beans.Score;

public interface ScoreService {
	public long addScore(Player player, int score);
	public Score[] getAllScores();
	public Score getScoreById(long id);
	public Score updateScore(Score score);
	public boolean deleteScore(long id);
}