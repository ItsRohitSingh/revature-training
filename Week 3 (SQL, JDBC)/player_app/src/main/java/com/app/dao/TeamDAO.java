package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Team;

public interface TeamDAO {
	public int getTeamByName(String name) throws BusinessException;

}
