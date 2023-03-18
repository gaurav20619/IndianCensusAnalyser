package com.bridgelabz.indiancensusanalyser;

public class IndianCensusData {
    public String state;
    public long population;
    public long areaInSqKm;
    public int densityPerSqKm;

    public IndianCensusData() {
    }

    public IndianCensusData(String state, long population, long areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }
}
