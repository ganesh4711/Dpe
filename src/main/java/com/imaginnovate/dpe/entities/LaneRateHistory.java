package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.EquipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lane_rate_history")
@EntityListeners(BaseEntityListener.class)
public class LaneRateHistory extends BaseEntity{


    private String originZip;
    private String destinationZip;
    private EquipmentType equipmentType;
    private String originCity;
    private String originState;
    private String destinationCity;
    private String destinationState;
    private String rateSource;
    private int duration;
    private double targetRate;
    private double avgRate;
    private double maxRate;
    private double miles;
    private double fuelSurcharge;
    private Date cacheDate;

    @Getter
    @Column(name = "meta_data")
    private  String metaData;

    @Column(name ="cache_date")
    public Date getCacheDate() {
        return cacheDate;
    }
    public void setCacheDate(Date cacheDate) {
        this.cacheDate = cacheDate;
    }
    public void setMetaData(String metaData){
        this.metaData=metaData;
    }
    public LaneRateHistory(String originZip, String destinationZip) {
        this.originZip = originZip;
        this.destinationZip = destinationZip;
    }

    @Column(name ="origin_zip")
    public String getOriginZip() {
        return originZip;
    }
    @Column(name = "destination_zip")
    public String getDestinationZip() {
        return destinationZip;
    }
    @Column(name ="equipment_type")
    @Enumerated(EnumType.ORDINAL)
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
    @Column(name = "origin_city")
    public String getOriginCity() {
        return originCity;
    }
    @Column(name ="origin_state" )
    public String getOriginState() {
        return originState;
    }
    @Column(name = "destination_city")
    public String getDestinationCity() {
        return destinationCity;
    }
    @Column(name = "destination_state")
    public String getDestinationState() {
        return destinationState;
    }
    @Column(name = "rate_source")
    public String getRateSource() {
        return rateSource;
    }
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }
    @Column(name = "target_rate")
    public double getTargetRate() {
        return targetRate;
    }
    @Column(name ="avg_rate" )
    public double getAvgRate() {
        return avgRate;
    }
    @Column(name = "max_rate")
    public double getMaxRate() {
        return maxRate;
    }
    @Column(name = "miles")
    public double getMiles() {
        return miles;
    }
    @Column(name = "fuel_surcharge")
    public double getFuelSurcharge() {
        return fuelSurcharge;
    }

    public void setOriginZip(String originZip) {
        this.originZip = originZip;
    }

    public void setDestinationZip(String destinationZip) {
        this.destinationZip = destinationZip;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setDestinationState(String destinationState) {
        this.destinationState = destinationState;
    }

    public void setRateSource(String rateSource) {
        this.rateSource = rateSource;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTargetRate(double targetRate) {
        this.targetRate = targetRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public void setMaxRate(double maxRate) {
        this.maxRate = maxRate;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public void setFuelSurcharge(double fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }
}
