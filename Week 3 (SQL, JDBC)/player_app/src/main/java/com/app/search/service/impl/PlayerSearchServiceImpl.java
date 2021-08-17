package com.app.search.service.impl;

import java.util.List;

import com.app.dao.PlayerSearchDAO;
import com.app.dao.impl.PlayerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.search.service.PlayerSearchService;

public class PlayerSearchServiceImpl implements PlayerSearchService {

	private PlayerSearchDAO playerSearchDAO=new PlayerSearchDAOImpl();
	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		if(id<100 ||id>1000) {
			throw new BusinessException("Invalid Player Id "+id);
		}else {
			//code here to DAO
			player=playerSearchDAO.getPlayerById(id);
			
		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;
		player=playerSearchDAO.getPlayerByContact(contact);
		return player;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList=null;
		if(name.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersByName(name);
		}else {
			throw new BusinessException("Invalid player name : "+name);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
		List<Player> playerList=null;
		if(teamName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersByTeamName(teamName);
		}else {
			throw new BusinessException("Invalid team name : "+teamName);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerList=null;
		if(age>=18 && age<=50) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersByAge(age);
		}else {
			throw new BusinessException("Invalid Player with age : "+age);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersBySportsName(String sportsName) throws BusinessException {
		List<Player> playerList=null;
		if(sportsName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersBySportsName(sportsName);
		}else {
			throw new BusinessException("Invalid sport name : "+sportsName);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByCity(String city) throws BusinessException {
		List<Player> playerList=null;
		if(city.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersByCity(city);
		}else {
			throw new BusinessException("Invalid City : "+city);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList=null;
		if(gender.matches("[a-zA-Z]{1}")) {
			//code here to DAO
			playerList=playerSearchDAO.getPlayersByGender(gender);
		}else {
			throw new BusinessException("Invalid Gender : "+gender);
		}
		return playerList;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playerList=playerSearchDAO.getAllPlayers();
		return playerList;
	}

	@Override
	public int deletePlayers(int id) throws BusinessException {
		int checkDelete = playerSearchDAO.deletePlayers(id);
		return checkDelete;
	}

	@Override
	public int updatePlayer(int id, long contact) throws BusinessException {
		int checkUpdate = playerSearchDAO.updatePlayer(id, contact);
		return checkUpdate;
	}

	@Override
	public int createPlayer(Player player) throws BusinessException {
		int checkInsert = playerSearchDAO.createPlayer(player);
		return checkInsert;
	}

}
