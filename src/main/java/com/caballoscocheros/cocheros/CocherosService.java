/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bquest
 */
@Path("")
public class CocherosService {

    private static final Logger LOG = Logger.getLogger(CocherosService.class.getName());

    private HorseStable store = HorseStable.getInstance();

    /**
     * Descarga la lista de capturas, si se pasa el parametro se descargan las
     * capturas despues de la fecha que se especifica.
     *
     * <p>
     * http://157.253.236.146:8060/cocheros/rest/download
     * </p>
     *
     * @param time la fecha opcional en formato ISO8601
     * (yyyy-MM-dd'T'HH:mm:ss.SSS'Z')
     * @return
     */
    @GET
    @Path("download")
    @Produces(MediaType.APPLICATION_JSON)
    public Response download(@QueryParam("time") String time) {
        if (time != null && !time.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Date cd = sdf.parse(time);

                List<HorseCapture> ret = new ArrayList<HorseCapture>();

                for (HorseCapture horse : store.getHorses()) {
                    Date hd = sdf.parse(horse.getTime());
                    if (hd.after(cd)) {
                        ret.add(horse);
                    }
                }

                return Response.ok(ret).build();
            } catch (ParseException ex) {
                return Response.serverError().build();
            }
        } else {
            List<HorseCapture> ret = new ArrayList<HorseCapture>();

            for (HorseCapture horse : store.getHorses()) {
                ret.add(horse);
            }

            return Response.ok(ret).build();
        }
    }

    /**
     * Punto para subir capturas.
     *
     * @param captures la lista de capturas a subir.
     *
     * <p>
     * http://157.253.236.146:8060/cocheros/rest/upload
     * </p>
     * @return 200
     */
    @POST
    @Path("upload")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upload(List<HorseCapture> captures) {
        for (HorseCapture capture : captures) {
            store.addHorse(capture);
        }

        return Response.ok().build();
    }
}
