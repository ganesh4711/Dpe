package com.imaginnovate.dpe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rate_source")
@EntityListeners(BaseEntityListener.class)
public class RateSource extends BaseEntity {

    private String name;
    private String code;
    private String description;
    private String rateField;
    private String rateDuration;

    @Column(name = "name")
    public String getName() {
        return name;
    }
    @Column(name = "code")
    public String getCode() {
        return code;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    @Column(name = "rate_field")
    public String getRateField() {return rateField;}

    @Column(name = "rate_duration")
    public String getRateDuration() {return rateDuration;}

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRateField(String rateField) {
        this.rateField = rateField;
    }

    public void setRateDuration(String rateDuration) {
        this.rateDuration = rateDuration;
    }

    /*public int[] getRateFields(){
        return new int[]{Integer.parseInt(Arrays.toString(rateField.split(",")))};
    }*/
}
