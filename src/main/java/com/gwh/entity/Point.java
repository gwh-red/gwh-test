package com.gwh.entity;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Point {
    /**
     * 经度（-180~180，东经正数，西经负数）
     */
    private double lng;
    /**
     * 维度（-90~90，北纬正数，南纬负数）
     */
    private double lat;

    public Point(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }
}