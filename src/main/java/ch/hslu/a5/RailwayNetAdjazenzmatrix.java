package ch.hslu.a5;

public class RailwayNet {

	private int noOfStations;
	private String[] stationName;
	private int[][] adjaMx;

	public RailwayNet(final String[] stationName, final int[][] adjaMx) {
		this.noOfStations = stationName.length;
		this.stationName = stationName;
		this.adjaMx = adjaMx;

	}

	public void addStation(final int[] station, final String stationName) {
		for (int i = 0; i <= noOfStations; i++) {
			adjaMx[i][noOfStations] = station[i];
		}
		for (int j = 0; j <= noOfStations; j++) {

			adjaMx[noOfStations][j] = station[j];
		}
		this.stationName[noOfStations] = stationName;
		noOfStations++;

	}

	public void removeStation(final int k) {
		--noOfStations;
		// k Spalte löschen und Spalten grösse als k nach links verschieben
		for (int i = 0; i < noOfStations; i++) {
			for (int j = k; j < noOfStations; j++) {
				adjaMx[i][j] = adjaMx[i][j + 1];
			}
		}
		// k Zeile löschen und Zeilen grösse als k nach oben verschieben
		for (int i = k; i < noOfStations; i++) {
			for (int j = 0; j < noOfStations; j++) {
				adjaMx[i][j] = adjaMx[i + 1][j];
			}
		}

		// letzte Spalte auf -1 setzten
		for (int i = 0; i < noOfStations; i++) {
			adjaMx[i][noOfStations] = -1;
			// letzte Zeile auf -1 setzten
		}
		for (int j = 0; j < noOfStations; j++) {
			adjaMx[noOfStations][j] = -1;
		}
		// String-Name aus stationName[] löschen und alles rechts davon links
		// verschieben
		for (int i = k; i < noOfStations; i++) {
			stationName[i] = stationName[i + 1];
		}
		stationName[noOfStations] = "";

	}

	public int getNoOfStations() {
		return noOfStations;
	}

	public int getNoRoutes() {
		int noRoutes = 0;
		for (int i = 0; i < noOfStations; i++) {
			for (int j = 0; j < noOfStations; j++) {
				if (adjaMx[i][j] > 0) {
					noRoutes++;
				}
			}
		}
		return noRoutes;
	}

	public String getStationName(final int i) {
		return stationName[i];
	}

	public int getIndexInStationsOf(final String a) {
		for (int i = 0; i < noOfStations; i++) {
			if (stationName[i] == a) {
				return i;
			}
		}
		throw new IllegalArgumentException("Statin doesnt exist");
	}

	public boolean hasRoute(final String a, final String b) {
		return this.hasRoute(getIndexInStationsOf(a), getIndexInStationsOf(b));

	}

	public boolean hasRoute(final int i, final int j) {
		if (adjaMx[i][j] > 0) {
			return true;
		}
		return false;
	}

	public int[] connectionsFrom(final String a) {
		return connectionsFrom(getIndexInStationsOf(a));
	}

	public int[] connectionsFrom(final int i) {
		int[] connectionsFromi = new int[noOfStations];
		int counter = 0;
		for (int j = 0; j < noOfStations; j++) {
			if (adjaMx[i][j] > 1) {
				connectionsFromi[counter] = j;
				counter++;
			}
		}
		return connectionsFromi;
	}

	public void printRailwayNet() {
		for (int i = 0; i < noOfStations; i++) {
			System.out.print(" [ ");
			for (int j = 0; j < noOfStations; j++) {
				if (adjaMx[i][j] > 9 || adjaMx[i][j] < 0) {
					System.out.print(adjaMx[i][j] + ", ");
				} else {
					System.out.print(" " + adjaMx[i][j] + ", ");
				}

			}
			System.out.println(" ]" + stationName[i]);
		}

	}

}
