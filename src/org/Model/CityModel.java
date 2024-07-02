package org.Model;
import java.util.*;
public class CityModel 
{
	int cityid;
	String cityname;
	public CityModel()
	{
		
	}
	public CityModel(int cityid, String cityname)
	{
		this.cityid=cityid;
		this.cityname=cityname;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	
}
