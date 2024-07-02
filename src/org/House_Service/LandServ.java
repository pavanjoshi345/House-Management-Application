package org.House_Service;

import org.Model.LandModel;
import org.house_Repository.LandRepository;
public class LandServ {
	LandRepository lrepo=new LandRepository();
	public boolean isAddProperties(LandModel model)
	{
		return lrepo.isAddProperties(model);
	}
	
	public int getLandSize(int lsize)
	{
		return lrepo.getLandSize(lsize);
	}
}

