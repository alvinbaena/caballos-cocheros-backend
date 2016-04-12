/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caballoscocheros.cocheros;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bquest
 */
@XmlRootElement
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
    private String time;
    private String syncTime;
    private Double longitude;
    private Double latitude;
    private String plate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.uuid != null ? this.uuid.hashCode() : 0);
        hash = 31 * hash + (this.time != null ? this.time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HorseCapture other = (HorseCapture) obj;
        if ((this.uuid == null) ? (other.uuid != null) : !this.uuid.equals(other.uuid)) {
            return false;
        }
        if ((this.time == null) ? (other.time != null) : !this.time.equals(other.time)) {
            return false;
        }
        return true;
    }
    
    
}
