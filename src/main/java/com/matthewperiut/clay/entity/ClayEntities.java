package com.matthewperiut.clay.entity;

import com.matthewperiut.clay.entity.horse.HorseEntities;
import com.matthewperiut.clay.entity.soldier.SoldierEntities;

public class ClayEntities
{
    public static void register()
    {
        SoldierEntities.register();
        HorseEntities.register();
    }
}
