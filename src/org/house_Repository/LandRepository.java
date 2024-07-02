package org.house_Repository;
import org.Database.DB_config;
import org.Model.LandModel;
public class LandRepository extends DB_config
{
	public boolean isAddProperties(LandModel model)
	{
		try
		{
		    stmt=conn.prepareStatement("insert into landsizemaster values('0',?)");
		    stmt.setInt(1,model.getLandsize());
		    int val=stmt.executeUpdate();
		    return val>0?true:false;
		}
		catch(Exception exp)
		{
			System.out.println("Exception is:"+exp);
			return false;	
		}
		
	}
	
	public int getLandSize(int lsize)
	{
		try
		{
		    stmt=conn.prepareStatement("select sqftid from landsizemaster where landsize=?");
		    stmt.setInt(1,lsize);
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
