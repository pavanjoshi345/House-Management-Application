package org.house_Repository;

import org.Database.DB_config;
import org.Model.property_model;

public class Property_repository extends DB_config
{
	 public boolean isAddNewproperty(property_model pmodel, int sqftid)
	 {
		try
		{
			stmt=conn.prepareStatement(" insert into property values('0',?,?,?,?)");
			stmt.setString(1,pmodel.getName());
			stmt.setString(2,pmodel.getAddress());
			stmt.setInt(3,pmodel.getId());
			stmt.setInt(4, sqftid);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				stmt=conn.prepareStatement("insert into historicalprices values('0',(select max(pid) from property),?,(select curdate()))");
				stmt.setInt(1,pmodel.getPrice());
				 value=stmt.executeUpdate();
				if(value>0)
				{
				   return true;
				}
				else
				{
					 return false;
				}
				
			}
			else
			{
				 return false;
			}
		}
		
		catch(Exception exp)
		{
			System.out.println("Exception is:"+exp);
			return false;
		}
		
		 
	 }
}
