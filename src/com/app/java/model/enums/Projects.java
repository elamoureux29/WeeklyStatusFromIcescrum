package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Projects {
    //    ENTRAPASSV740("EntraPass v7.40", "TSP1323"), ENTRAPASSV750("EntraPass v7.50", "TSP1329"),
    //    ENTRAPASSV760("EntraPass v7.60", "TSP1335"), ENTRAPASSV800("EntraPass v8.00", "TSP1326"),
    ENTRAPASSV810("EntraPass v8.10", "EPV810"), ENTRAPASSV820("EntraPass v8.20", "EPV820"),
    ENTRAPASSWEBV820("EntraPass Web v8.20", "EPWEBV820"),
    //    EPGOV240("EP go v2.40", "TSP1323A"), EPGOV250("EP go v2.50", "TSP1329A"),
    EPGOV260("EP go v2.60", "TSP1326B"), EPGOV270("EP go v2.70", "EPGOV270"),
    EPGOV300("EP go v3.00", "EPGOV300"),
    //    EPGOPASSV120("EP go Pass v1.20", "TSP1283B"),
    EPGOPASSV130("EP go Pass v1.30", "TSP1329B"),
    //    EPGOINSTALLV140("EP go Install v1.40", "TSP1283A"),
    EPGOINSTALLV150("EP go Install v1.50", "TSP1329C"), EPGOINSTALLV160("EP go Install v1.60", "EPGOI160"),
    EPGOINSTALLV170("EP go Install v1.70", "EPGOI170"),
    //    INTEVO("Intevo gen 2", "TSP1324"),
    //    EPKTSAV210("EP KT Standalone v2.10", "TSP1007"),
    EPKT2V100("EP KT-2 v1.00", "TSP1159"),
    SBFY19("Starbugs FY19", "SBFY19"),
    VOLTSFY19("Voltigeurs FY19", "VOLTSFY19"),
    ACDCFY19("ACDC FY19", "ACDCFY19");

    private String prjName;
    private String identifier;

    Projects(String s1, String s2) {
        prjName = s1;
        identifier = s2;
    }

    public String getPrjName() {
        return prjName;
    }

    public String getIdentifier() {
        return identifier;
    }
}
