package org.house_Client;
import java.util.*;

import org.House_Service.Area_serv;
import org.House_Service.CityServ;
import org.House_Service.LandServ;
import org.House_Service.Property_service;
import org.Model.AreaModel;
import org.Model.CityModel;
import org.Model.LandModel;
import org.Model.property_model;

import java.sql.*;
public class House_Client_app {

	public static void main(String[] args) throws  Exception
	{
		Scanner sc=new Scanner(System.in);
		int cityid;
		String cityname;
		CityServ src=new CityServ();
		 LandServ lsrc=new LandServ();
		Area_serv aserv=new Area_serv();
		Property_service pserv=new Property_service();
		do
		{
			System.out.println("Enter the Your Choice....");
			System.out.println("😎=================================================😎");
			System.out.println("1: Add New City");
			System.out.println("2: View All Data");
		    System.out.println("3: Add New Area");
		    System.out.println("4: Display Information of City");
		    System.out.println("5: Add New Property");
		    System.out.println("6: Add City Details");
		    System.out.println("7: LOGOUT");
		    System.out.println("😎=================================================😎");
			int choice=sc.nextInt();
			System.out.println("Your Choice is:-"+choice);
			switch(choice)
			{
			case 1:
				System.out.println("Enter City Name");
				sc.nextLine();
				cityname=sc.nextLine();
				CityModel model=new CityModel();
				model.setCityname(cityname);
				boolean b=src.isAddiCity(model);
				if(b)
				{
					System.out.println("New City Added Successfully.........");
				}
				else
				{
					System.out.println("Some Problem is there......");
				}
				break;
		 
			case 2:
				 
				 System.out.println("Display All Information of City....");
				 System.out.println("😊================================================");
				 System.out.println("\tCityId\t\t\t CityName");
			     System.out.println("=================================================");
				 List<CityModel> list=src.viewAllData();
				 {
					  for(CityModel cm:list)
					  {
						  System.out.println("\t"+cm.getCityid()+"\t\t"+cm.getCityname());
					  }
				 }
				 System.out.println("😊==================================================😊");
				 break;
				 
			case 3:
				System.out.println("Enter the City Name");
				sc.nextLine();
				cityname=sc.nextLine();
				int result=src.getCityidByName(cityname);
				if(result==0)
				{
			        System.out.println("This City Not Present\n Do You Want Add This city then press yes");
			        String ch=sc.nextLine();
			        if(ch.equals("yes"))
			        {
			        	
			         model=new CityModel();
					 model.setCityname(cityname);
				    b=src.isAddiCity(model);
					if(b)
					{
						System.out.println("New City Added Successfully.........");
					}
					else
					{
						System.out.println("Some Problem is there......");
					}
			        }
			        else
			        {
			        	 System.out.println("Its Ok");
			        }
				}
				else if(result!=0)
				{
					System.out.println("Enter the Areaname of that city..");
					String areaname=sc.nextLine();
					System.out.println("Enter the PINCODE of area...");
					String pincode=sc.nextLine();
					AreaModel amodel=new AreaModel();
					amodel.setAreaname(areaname);
					amodel.setCityid(result);
					amodel.setPincode(pincode);
				    b=aserv.isAddArea(amodel);
					if(b)
					{
						System.out.println("Area Added Successfully......");
					}
					else
					{
						System.out.println("Area Not Added Success....");
					}
							
				}
				
				else
				{
					System.out.println("Some Exception...");
				}
				break;
	
			case 4:
			   List<AreaModel> list2=new ArrayList();
			   Area_serv asrc=new Area_serv();
			   System.out.println("View All Cityes...");
			   List<AreaModel>list11=asrc.viewData();
			   {
				   for(AreaModel acm:list11)
				   {
					   System.out.println(acm.getCityname()+"\t"+acm.getAreaname()+acm.getPincode());
				   }
			   }
			   break;
			 
			case 5:
			  
			  int landsize;
			  System.out.println("Enter the Land Size");
			  landsize=sc.nextInt();
			  LandModel lmodel=new LandModel();
			  lmodel.setLandsize(landsize);
			  b=lsrc.isAddProperties(lmodel);
			  if(b)
			  {
				  System.out.println("Properties Add Successfully.......");
			  }
			  else
			  {
				  System.out.println("Not Add Property");
			  }
			  break;
			
	case 6:
		   sc.nextLine();
		   System.out.println("Enter the City Name");
		   cityname=sc.nextLine();
		   result=src.getCityidByName(cityname);
		   List<String>areaNames=aserv.arealist(result);
		   System.out.println("Input AreaName from given List:");
		   for(String aname:areaNames)
		   {
			   System.out.println(aname);
		   }
		  
		    System.out.println("Enter the AreaName..");
		    String areaname=sc.nextLine();
			int aid=aserv.getAreaId(areaname);
			System.out.println("Areaname is:"+aid);
			System.out.println("Enter the LandSize");
			int lsize=sc.nextInt();
			int sqftid=lsrc.getLandSize(lsize);
			System.out.println("Area Land Size id is:"+sqftid);
			System.out.println("Enter the property");
			sc.nextLine();
			String pname=sc.nextLine();
			System.out.println("Enter the property address");
			String paddress=sc.nextLine();
			System.out.println("Enter the Property price");
			int price=sc.nextInt();
			property_model prmodel=new property_model();
			prmodel.setAddress(paddress);
			prmodel.setName(pname);
			prmodel.setPrice(price);
			prmodel.setId(aid);
			b=pserv.isAddNewproperty(prmodel, sqftid);
			if(b)
			{
				System.out.println("New Property Added Successfully......");
			}
			else
			{
				 System.out.println("Some Problem is there......");
			}
			break;
	
	case 7:
		  System.out.println("Your Are Exited In CODE...........");
		  System.exit(0);
		  
			}
		}while(true);
	}
}



 