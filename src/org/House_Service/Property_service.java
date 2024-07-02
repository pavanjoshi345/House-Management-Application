package org.House_Service;

import org.Model.property_model;
import org.house_Repository.Property_repository;

public class Property_service 
{
	Property_repository  psrepo=new Property_repository();
	public boolean isAddNewproperty(property_model pmodel, int sqftid)
	{
		return psrepo.isAddNewproperty(pmodel, sqftid);
		
	}
	  
}
