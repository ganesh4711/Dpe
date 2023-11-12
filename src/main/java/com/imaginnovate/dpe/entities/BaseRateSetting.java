package com.imaginnovate.dpe.entities;


import com.imaginnovate.dpe.common.Enums.RateField;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "base_rate_setting")
@EntityListeners(BaseEntityListener.class)
public class BaseRateSetting extends BaseEntity {

    private RateSource rateSource;

    private BaseRateConfiguration baseRateConfig;

    private double weightage;

    private RateField rateField;

    private int rateDuration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_source_id")
    public RateSource getRateSource(){
        return  rateSource;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_rate_config_id")
    public BaseRateConfiguration getBaseRateConfig(){
        return baseRateConfig;
    }
    @Column(name = "weightage")
    public double getWeightage() {
        return weightage;
    }
    @Column(name = "rate_field")
    @Enumerated(EnumType.ORDINAL)
    public RateField getRateField() {
        return rateField;
    }
    @Column(name = "rate_duration")
    public int getRateDuration() {
        return rateDuration;
    }

    public void setRateSource(RateSource rateSource) {
        this.rateSource = rateSource;
    }

    public void setBaseRateConfig(BaseRateConfiguration baseRateConfig) {
        this.baseRateConfig = baseRateConfig;
    }

    public void setWeightage(double weightage) {
        this.weightage = weightage;
    }

    public void setRateField(RateField rateField) {
        this.rateField = rateField;
    }

    public void setRateDuration(int rateDuration) {
        this.rateDuration = rateDuration;
    }
}
