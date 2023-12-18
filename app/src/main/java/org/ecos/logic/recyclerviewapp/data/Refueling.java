package org.ecos.logic.recyclerviewapp.data;

import java.io.Serializable;

public class Refueling implements Serializable {
    private int refuelingId;
    private int type;
    private String date;
    private double litres;
    private int km;
    private int gasStationId;

    public Refueling(int refuelingId, int type, String date, double litres, int km, int gasStationId) {
        this.refuelingId = refuelingId;
        this.type = type;
        this.date = date;
        this.litres = litres;
        this.km = km;
        this.gasStationId = gasStationId;
    }

    public int getRefuelingId() {
        return refuelingId;
    }

    public void setRefuelingId(int refuelingId) {
        this.refuelingId = refuelingId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLitres() {
        return litres;
    }

    public void setLitres(double litres) {
        this.litres = litres;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getGasStationId() {
        return gasStationId;
    }

    public void setGasStationId(int gasStationId) {
        this.gasStationId = gasStationId;
    }
}