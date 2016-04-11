/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bquest
 */
public class CocherosService {

    @Inject
    private HorseStable store;

    @Path("/download")
    @Produces(MediaType.APPLICATION_JSON)
    public Response download(@QueryParam("time") String time) {
        if (time != null && time.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Date cd = sdf.parse(time);

                Set<HorseCapture> ret = new HashSet<HorseCapture>();

                while (store.getHorses().hasNext()) {
                    HorseCapture horse = store.getHorses().next();

                    if (horse.getTime().after(cd)) {
                        ret.add(horse);
                    } else {
                        break;
                    }
                }

                return Response.ok(ret).build();
            } catch (ParseException ex) {
                return Response.serverError().build();
            }
        } else {
            Set<HorseCapture> ret = new HashSet<HorseCapture>();

            while (store.getHorses().hasNext()) {
                HorseCapture horse = store.getHorses().next();
                ret.add(horse);
            }

            return Response.ok(ret).build();
        }
    }

    @Path("/upload")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upload(List<HorseCapture> captures) {
        for (HorseCapture capture : captures) {
            store.addHorse(capture);
        }

        return Response.ok().build();
    }
}
