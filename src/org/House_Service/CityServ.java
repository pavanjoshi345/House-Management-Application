package org.House_Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.Model.CityModel;
import org.house_Repository.City_Repository;
public class CityServ 
{
	City_Repository repo=new City_Repository();
	List<CityModel> list=new ArrayList<CityModel>();
	public boolean isAddiCity(CityModel model) throws SQLException
	{
		return repo.isAddCity(model);
	}
	
	public List<CityModel> viewAllData()
	{
		return repo.viewAllData();	
	}
	
	public int getCityidByName(String cityname)
	{
		return repo.getCityidByName(cityname);
	}
}
