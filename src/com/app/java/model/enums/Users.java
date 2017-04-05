package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Users {
    FCOSSETTE("François Cossette", 38848, false), FMOLINA("Felipe Molina", 38856, false), IOULDOUALI("Iddir Ould-Ouali", 37897, false), FMORIN("François Morin", 38750, true),
    SFRENETTE("Stéphan Frenette", 36655, true), FLAKHDAR("Fouad Lakhdar", 38849, false), BCARON("Bernard Caron", 38857, false), YSELIVANOVA("Yulia Selivanova", 38858, false),
    ELAMOUREUX("Erik Lamoureux", 20218, true), BLUSSIER("Benoit Lussier", 38859, false), FDAMOURS("Francis D'Amours", 38861, false), ACOLLINS("Adrian Collins", 38860, false),
    DLABRIE("Danny Labrie", 38881, false), DALVAREZ("Daniel Alvarez", 38862, false), GLABRECQUE("Gabriel Labrecque", 38745, true), MBENAZZOUZ("Makrem Ben Azzouz", 38863, false),
    ATRAORE("Alizata Traore", 38852, false), BDRESLER("Brandon Dresler", 38853, false), JSDECOSTE("J-S Decoste", 38746, true), JBOURGOIN("Jonathan Bourgoin", 38854, false),
    YLEBEL("Yannick Lebel", 38865, false), PSOULIERE("Patrick Soulière", 38748, true), RDUBEY("Rajeev Dubey", 14191, true), CNARCISSELOWE("Claude Narcisse Lowe", 39455, false);

    private String userName;
    private int identifier;
    private boolean manager;

    Users(String s1, int i1, boolean b1) {
        userName = s1;
        identifier = i1;
        manager = b1;
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
}
