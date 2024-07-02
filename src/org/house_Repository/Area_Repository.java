package org.house_Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Database.DB_config;
import org.Model.AreaModel;

public class Area_Repository extends DB_config
{  
	List<String>arealist;
	List<AreaModel> list=new ArrayList<AreaModel>();
   public boolean isAddArea(AreaModel amodel) throws Exception
   {
	   try
	   {
		   
	   
	   cstml=conn.prepareCall("{call savearea(?,?,?)}");
	   cstml.setString(1,amodel.getAreaname());
	   cstml.setInt(2,amodel.getCityid());
	   cstml.setString(3,amodel.getPincode());
	   boolean  b=cstml.execute();
	   return !b;
	   }
	   catch(Exception exp)
	   {
		   System.out.println("Exception is:"+exp);
		   return false;
	   }
	  
   }
   
   public List<AreaModel> viewData()
   {
	  try
	  {
		  stmt=conn.prepareStatement("select c.cityname as'Cityname', a.areaname as'Areaname', acj.pincode as'PINCODE' from citymaster c inner join areacityjoin acj on c.cityid=acj.cityid inner "
		  		+ "join areamaster a on a.aid=acj.aid");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			   AreaModel model=new AreaModel();
			   model.setCityname(rs.getString(1));
			   model.setAreaname(rs.getString(2));
			   model.setPincode(rs.getString(3));
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
   
   public List<String>arealist(int cityid)
   {
	 try
	 {
		arealist=new ArrayList<String>();
		stmt=conn.prepareStatement("select a.areaname as'areaname'  from areamaster a inner join areacityjoin ac on a.aid=ac.aid inner join citymaster ct on ct.cityid=ac.cityid where ac.cityid=?");
		stmt.setInt(1, cityid);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			arealist.add(rs.getString(1));
		}
		return arealist.size()>0?arealist:null;
	 }
	 catch(Exception exp)
	 {
		 System.out.println("Exception is:"+exp);
		 return null;
	 }
  
   }
  
    public int getAreaId(String areaname)
    {
    	 try
    	 {
    		arealist=new ArrayList<String>();
    		stmt=conn.prepareStatement("select aid from areamaster where areaname=?");
    		stmt.setString(1,areaname);
    		rs=stmt.executeQuery();
    		if(rs.next())
    		{
    			return rs.getInt(1);
    		}
    		else
    		{
    			 return 0;
    		}
    	 }
    	 catch(Exception exp)
    	 {
    		 System.out.println("Exception is:"+exp);
    		 return 0;
    	 }
    }
   
}
