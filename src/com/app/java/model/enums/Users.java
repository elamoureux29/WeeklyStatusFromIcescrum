package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Users {
    FCOSSETTE("François Cossette", 38848, false, "DEV"), FMOLINA("Felipe Molina", 38856, false, "DEV"),
    IOULDOUALI("Iddir Ould-Ouali", 37897, false, "DEV"), FMORIN("François Morin", 38750, true, "PVV"),
    SFRENETTE("Stéphan Frenette", 36655, true, "ADM"), FLAKHDAR("Fouad Lakhdar", 38849, false, "DEV"),
    BCARON("Bernard Caron", 38857, false, "DEV"), YSELIVANOVA("Yulia Selivanova", 38858, false, "PVV"),
    ELAMOUREUX("Erik Lamoureux", 20218, true, "ADM"), BLUSSIER("Benoit Lussier", 38859, false, "PVV"),
    FDAMOURS("Francis D'Amours", 38861, false, "PVV"), ACOLLINS("Adrian Collins", 38860, false, "PVV"),
    DLABRIE("Danny Labrie", 38881, false, "PVV"), DALVAREZ("Daniel Alvarez", 38862, false, "DEV"),
    GLABRECQUE("Gabriel Labrecque", 38745, true, "ADM"), MBENAZZOUZ("Makrem Ben Azzouz", 38863, false, "PVV"),
    ATRAORE("Alizata Traore", 38852, false, "PVV"), BDRESLER("Brandon Dresler", 38853, false, "DEV"),
    JSDECOSTE("J-S Decoste", 38746, true, "ADM"), JBOURGOIN("Jonathan Bourgoin", 38854, false, "PVV"),
    YLEBEL("Yannick Lebel", 38865, false, "DEV"), PSOULIERE("Patrick Soulière", 38748, true, "PVV"),
    RDUBEY("Rajeev Dubey", 14191, true, "ADM"), CNARCISSELOWE("Claude Narcisse Lowe", 39455, false, "PVV");

    private String userName;
    private int identifier;
    private boolean manager;
    private String group;

    Users(String s1, int i1, boolean b1, String s2) {
        userName = s1;
        identifier = i1;
        manager = b1;
        group = s2;
    }

    public String getUserName() {
        return userName;
    }

    public int getIdentifier() {
        return identifier;
    }

    public boolean isManager() {
        return manager;
    }

    public String getGroup() {
        return group;
    }
}
