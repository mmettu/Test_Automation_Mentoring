package com.epam.tam.module.testdata;

public class Country {
	private String originCountry;
	private String destinationCountry1;
	private String destinationCountry2;
	public Country(){
		this.originCountry="Belgium";
		this.destinationCountry1="Germany";
		this.destinationCountry2="Hungary";
	}
	public Country(String originCountry,String destinationCountry1,String destinationCountry2){
		this.originCountry=originCountry;
		this.destinationCountry1=destinationCountry1;
		this.destinationCountry2=destinationCountry2;
	}
	public String getoriginCountry(){
		return originCountry;
		
	}
	public String getdestinationCountry1(){
		return destinationCountry1;
		
	}	
	public String getdestinationCountry2(){
		return destinationCountry2;
		
	}	
}
