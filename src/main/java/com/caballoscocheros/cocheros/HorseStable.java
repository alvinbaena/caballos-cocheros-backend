/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author bquest
 */
@ApplicationScoped
public class HorseStable {

    private final ConcurrentSkipListSet<HorseCapture> store = new ConcurrentSkipListSet<HorseCapture>(new Comparator<HorseCapture>() {

        @Override
        public int compare(HorseCapture o1, HorseCapture o2) {
            return o1.getTime().compareTo(o2.getTime());
        }
    });

    public void addHorse(HorseCapture hc) {
        store.add(hc);
    }

    /**
     * Ascendiente
     *
     * @return Iterador descendente por fecha.
     */
    public Iterator<HorseCapture> getHorses() {
        return store.descendingIterator();
    }
}
