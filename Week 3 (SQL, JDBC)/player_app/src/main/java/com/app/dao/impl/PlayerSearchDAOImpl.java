package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.PlayerSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.model.Team;

public class PlayerSearchDAOImpl  implements PlayerSearchDAO{
	private static Logger log = Logger.getLogger(PlayerSearchDAOImpl.class);
	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				player=new Player();
				player.setId(id);
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
			}else {
				throw new BusinessException("Entered player id "+id+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.contact=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
			}else {
				throw new BusinessException("Entered player contact "+contact+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.name=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players with name : "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where t.teamName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players for team "+teamName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.age=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, age);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players with age : "+age);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersBySportsName(String sportsName) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.sportsName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, sportsName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players for sports "+sportsName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByCity(String city) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.city=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, city);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players from "+city);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.gender=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players belonging to gender "+gender);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id";
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			
			if(playerList.size()==0) {
				throw new BusinessException("No Players available");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return playerList;
	}

	@Override
	public int deletePlayers(int id) throws BusinessException {
		int d = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "delete from player where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			d = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return d;
	}

	@Override
	public int updatePlayer(int id, long contact) throws BusinessException {
		int u = 0;

		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update player set contact = ? where id = ? ;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			preparedStatement.setInt(2, id);

			u = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Internal error occured contact sysadmin");
		}

		return u;
	}

	@Override
	public int createPlayer(Player player) throws BusinessException {
		int c = 0;

		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into player (id, name, age, gender, city, sportsName, contact, teamId) values (?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getGender());
			preparedStatement.setString(5, player.getCity());
			preparedStatement.setString(6, player.getSportsName());
			preparedStatement.setLong(7, player.getContact());
			preparedStatement.setInt(8, player.getTeam().getId());

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Internal error occured contact sysadmin");
		}

		return c;
	}

}
