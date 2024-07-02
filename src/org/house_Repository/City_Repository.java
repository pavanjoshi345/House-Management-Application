package org.house_Repository;
import org.Database.DB_config;
import org.Model.CityModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class City_Repository extends DB_config
{
     List<CityModel> list=new ArrayList<CityModel>();
	public boolean isAddCity(CityModel model) throws SQLException
	{
		try
		{
		stmt=conn.prepareStatement("insert into citymaster values('0',?)");
		stmt.setString(1,model.getCityname());
		int val=stmt.executeUpdate();
		 return val>0?true:false;
		}
		catch(Exception exp)
		{
			System.out.println("Excepiton is:"+exp);
			return false;
		}
		
	}
	
	public List<CityModel> viewAllData()
	{
	    try
	    {
	    	
	      stmt=conn.prepareStatement("select *from citymaster");
	      rs=stmt.executeQuery();
	      while(rs.next())
	      {
	    	 CityModel model=new CityModel();
	    	 model.setCityid(rs.getInt(1));
	    	 model.setCityname(rs.getString(2));
	    	 list.add(model);
	      }
	      return list.size()>0?list:null;
	    }
	    catch(Exception exp)
	    {
	    	System.out.println("Exception is:"+exp);
	    }
		return null;
	}
	
	public int getCityidByName(String cityname)
	{
		try
		{
			stmt=conn.prepareStatement(" select *from citymaster where cityname=?");
			stmt.setString(1, cityname);
			rs=stmt.executeQuery();
		    if(rs.next())
		    {
		    	return rs.getInt(1);
		    }
		    else
		    {
		    }	 return 0;
		
		}
		catch(Exception exp)
		{
			System.out.println("Exception is:"+exp); 
			return -1;
		}
	}
	
}
