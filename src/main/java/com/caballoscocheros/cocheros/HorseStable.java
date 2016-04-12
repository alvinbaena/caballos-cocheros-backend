/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bquest
 */
public class HorseStable {
    
    private static HorseStable instance;

    private final Set<HorseCapture> store = Collections.synchronizedSet(new HashSet<HorseCapture>());
    
    public static HorseStable getInstance(){
        if (instance == null){
            instance = new HorseStable();
        }
        
        return instance;
    }
        
    private HorseStable(){
    }

    public void addHorse(HorseCapture hc) {
        store.add(hc);
    }

    public Set<HorseCapture> getHorses(){
        return store;
    }
}
