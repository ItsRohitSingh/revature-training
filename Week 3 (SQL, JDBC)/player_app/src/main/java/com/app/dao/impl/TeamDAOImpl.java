package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.TeamDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.model.Team;

public class TeamDAOImpl implements TeamDAO {
	
	@Override
	public int getTeamByName(String name) throws BusinessException {
		Team team = new Team();
		List<Team> teamList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select t.id,teamName from team where t.teamname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				team.setId(resultSet.getInt("id"));
				team.setTeamName(resultSet.getString("teamname"));
			}
			
			if(teamList.size()==0) {
//				int c = 0;
//					String sql1 = "insert into team (teamname) values (?)";
//
//					PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
//					
//					preparedStatement1.setString(1, team.getTeamName());
//					
//					c = preparedStatement.executeUpdate();
//					if(c==1) {
//						ResultSet resultSet1=preparedStatement.getGeneratedKeys();
//						if(resultSet1.next()) {
//							team.setId(resultSet1.getInt(1));
//						}
//					}
				} 
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return team.getId();
	}

}
