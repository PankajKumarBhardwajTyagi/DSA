package service;

import beans.Player;
import exceptions.ExcessPlayerException;
import exceptions.NoPlayersExist;
import exceptions.PlayerNotFoundException;

public interface PlayerService {
	public long addPlayer(String name, int age, String type) throws ExcessPlayerException;
	public Player[] getAllPlayers() throws NoPlayersExist;
	public Player getPlayerById(long id) throws PlayerNotFoundException;
	public Player updatePlayer(Player player) throws PlayerNotFoundException;
	public boolean deletePlayer(long id) throws PlayerNotFoundException;
}