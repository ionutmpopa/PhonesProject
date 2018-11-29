package com.iopo;

import java.util.ArrayList;

public class SamsungGalaxy6 extends Samsung {

    private static final int BATTERYLIFE = 45;

    public SamsungGalaxy6(String color, String material, String imei) {
        super(color, material, imei, BATTERYLIFE);
    }
}
