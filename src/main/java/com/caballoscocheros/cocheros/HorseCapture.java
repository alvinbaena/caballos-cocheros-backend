/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.util.Date;

/**
 *
 * @author bquest
 */
public class HorseCapture {

    /*
     {
     "uuid" : "string",
     "time" : "ISO 8601 date en utc",
     "syncTime" "ISO 8601 date en utc",
     "longitude" : double,
     "latitude" : double,
     "plate" : "string"
     }
     */
    private String uuid;
    private Date time;
    private Date syncTime;
    private Double longitude;
    private Double latitude;
    private String plate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    
}
