package ch.hslu.a5;

public class RailwayNetDemo {

	public static void main(final String[] args) {
		String[] stationName= {"Olten", "Aarau", "Brugg", "Dietikon", "Zürich", "Lenzburg", "Zofigen", "Wohlen", "Luzern", "Rotkreuz", "Zug", "Pfäffikon", "Arth-Goldau"};
		int[][] adjaMx= {
//		Ol  Ar  Br  Die Zü Len  Zof Woh Lu  Ro  Zu Pfä  Arth-Go
		{0,  13, -1, -1, 36, -1 , 7 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 }, //Ol
		{13,  0, 13, -1, -1,  8 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 }, //Ar
		{-1, 13,  0, 16, -1, 16 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 },//BR
		{-1, -1, 16,  0, 12,  9 ,-1 ,30 ,-1 ,-1 ,-1 ,-1 ,-1 },//Die
		{-1, -1, -1, 12,  0, 19 ,-1 ,-1 ,-1 ,-1 ,25 ,30 ,-1 },//Zü
		{-1,  8, 16, 19, 19,  0,34 , 9 ,80 ,-1 ,-1 ,-1 ,-1 },//Lenz
		{ 7, -1, -1, -1, -1, 34 , 0 ,-1 ,35 ,-1 ,-1 ,-1 ,-1 },//Zof
		{-1, -1, -1, 30, -1,  9 ,-1 , 0 ,-1 ,23 ,-1 ,-1 ,-1 },//Woh
		{-1, -1, -1, -1, -1, 80 ,35 ,-1 , 0 ,16 ,-1 ,-1 ,30 },//Lu
		{-1, -1, -1, -1, -1, -1 ,-1 ,23 ,16 , 0 ,12 ,-1 ,15 },//Rot
		{-1, -1, -1, -1, 25, -1 ,-1 ,-1 ,-1 ,12 , 0 ,-1 ,20 },//Zug
		{-1, -1, -1, -1, 30, -1 ,-1 ,-1 ,-1 ,-1 ,-1 , 0 ,39 },//Pfä
		{-1, -1, -1, -1, -1, -1 ,-1 ,-1 ,30 ,15 ,20 ,39 , 0 },//Arth-Gol
		};
		RailwayNet railwayNet= new RailwayNet(stationName, adjaMx);
		railwayNet.printRailwayNet();
	
	}
}
