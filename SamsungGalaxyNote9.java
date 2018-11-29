package com.iopo;

import java.util.ArrayList;

public class SamsungGalaxyNote9 extends Samsung {

    private static final int BATTERYLIFE = 50;

    public SamsungGalaxyNote9(String color, String material, String imei) {
        super(color, material, imei, BATTERYLIFE);
    }
}
