package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Users {
    FCOSSETTE("François Cossette", 38848), FMOLINA("Felipe Molina", 38856), IOULDOUALI("Iddir Ould-Ouali", 37897), FMORIN("François Morin", 38750), SFRENETTE("Stéphan Frenette", 36655),
    FLAKHDAR("Fouad Lakhdar", 38849), BCARON("Bernard Caron", 38857), ECORMIER("Eric Cormier", 38850), YSELIVANOVA("Yulia Selivanova", 38858), ELAMOUREUX("Erik Lamoureux", 20218),
    BLUSSIER("Benoit Lussier", 38859), FDAMOURS("Francis D'Amours", 38861), ACOLLINS("Adrian Collins", 38860), DLABRIE("Danny Labrie", 38881), DALVAREZ("Daniel Alvarez", 38862),
    GLABRECQUE("Gabriel Labrecque", 38745), MBENAZZOUZ("Makrem Ben Azzouz", 38863), ATRAORE("Alizata Traore", 38852), BDRESLER("Brandon Dresler", 38853), JSDECOSTE("J-S Decoste", 38746),
    JBOURGOIN("Jonathan Bourgoin", 38854), YLEBEL("Yannick Lebel", 38865), PSOULIERE("Patrick Soulière", 38748), RDUBEY("Rajeev Dubey", 14191), CNARCISSELOWE("Claude Narcisse Lowe", 39455);

    private String userName;
    private int identifier;

    Users(String s1, int i1) {
        userName = s1;
        identifier = i1;
    }

    public String getUserName() {
        return userName;
    }

    public int getIdentifier() {
        return identifier;
    }
}
