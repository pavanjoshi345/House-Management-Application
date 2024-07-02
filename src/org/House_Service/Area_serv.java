package org.House_Service;

import java.util.ArrayList;
import java.util.List;

import org.Model.AreaModel;
import org.house_Repository.Area_Repository;

public class Area_serv 
{
    Area_Repository arepo=new Area_Repository();
    List<AreaModel>list=new ArrayList();
	public boolean isAddArea(AreaModel amodel) throws Exception
	{
		return arepo.isAddArea(amodel);
	}
	
	public List<AreaModel>viewData()
	{
		return arepo.viewData();
	}
	
	public List<String>arealist(int cityid)
	{
		return arepo.arealist(cityid);
		
	}
	
	public int getAreaId(String areaname)
	{
		return arepo.getAreaId(areaname);
	}
}

