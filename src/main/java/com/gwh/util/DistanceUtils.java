package com.gwh.util;


import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

import java.math.BigDecimal;

/**
 * @ClassName: DistanceUtils
 * @Description: 根据经纬度计算距离
 */
public class DistanceUtils {

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitudeFrom 第一个点的经度
     * @param latitudeFrom  第一个点的纬度
     * @param longitudeTo   第二个点的经度
     * @param latitudeTo    第二个点的纬度
     * @return 返回距离 单位米 M
     */
    public static double getDistance(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo) {
        GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
        GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);
        return new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
    }

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitudeFrom 第一个点的经度
     * @param latitudeFrom  第一个点的纬度
     * @param longitudeTo   第二个点的经度
     * @param latitudeTo    第二个点的纬度
     * @param accurate      保留小数点几位
     * @return 返回距离 单位千米 KM
     */
    public static double getDistance(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo, int accurate) {
        double distance = getDistance(longitudeFrom, latitudeFrom, longitudeTo, latitudeTo);
        if (accurate < 0) {
            throw new RuntimeException("精确度必须是正整数或零");
        }
        return new BigDecimal(distance).divide(new BigDecimal(1), accurate, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        double result = getDistance(113.364045, 22.977127, 113.361726, 22.949743, 2);
        System.out.println("经纬度距离计算结果：" + result + "千米");
    }

}


