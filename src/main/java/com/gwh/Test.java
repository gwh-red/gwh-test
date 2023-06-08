package com.gwh;

import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    /**
     * 判断2个区域是否重合
     *
     * @param args
     */
    public static void main(String[] args) {

        List<String> string1 = Arrays.asList("113.29901268750427,23.045263409662542|113.41488411694763,23.02409482622341|113.49350502759216,23.048106697334013|113.51702263623474,23.014931274085242|113.50826790601013,22.976690426761877|113.48114540845154,22.91274716343368|113.37540200024841,22.898753078798553|113.3029608991742,22.877719705345203|113.2150702741742,22.903971380906107|113.24717095166443,22.942232792124262|113.21747353345154,22.965627005623723|".split("\\|"));
        List<String> strings0 = Arrays.asList("113.50635040283203,22.938987923532842|113.52832305908203,22.880799613004275|113.5654019165039,22.861819767095497|113.5599087524414,22.91685400980975|113.5324429321289,22.978819848653952|113.50841033935546,22.960485975174294|".split("\\|"));

        List<Location> locationList9 = new ArrayList<>();
        List<Location> locationList10 = new ArrayList<>();
        System.out.println(string1);
        string1.forEach(str -> {

            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                locationList9.add(new Location(Double.valueOf(split[0]), Double.valueOf(split[1])));
            }
        });

        strings0.forEach(str -> {

            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                locationList10.add(new Location(Double.valueOf(split[0]), Double.valueOf(split[1])));
            }
        });


        boolean a = isCoinCide(locationList9, locationList10);
        if (isCoinCide(locationList9, locationList10)) {
            System.out.println("是否存在重合区域:" + a);
        }
        System.out.println("是否存在重合区域:" + a);

    }

    private static boolean isCoinCide(List<Location> locationList, List<Location> locationList2) {
        //获取四边形的线段
        List<Line> lineList = getLines(locationList);
        //获取三角形的线段
        List<Line> lineList2 = getLines(locationList2);
        //判断是否相交
        boolean isIntersect = isIntersect(lineList, lineList2);
        if (isIntersect) {
            return true;
        }
        //如果不相交判断是否包含-由于没有相交线段只要存在点在多边形内就说明包含
        boolean isPolygonInPolygon = isPolygonInPolygon(locationList, locationList2);
        if (isPolygonInPolygon) {
            return true;
        }
        return false;
    }

    private static boolean isPolygonInPolygon(List<Location> locationList, List<Location> locationList2) {
        //判断第一个多边形是否在第二个多边形内
        for (Location location : locationList) {
            boolean isPointInPolygon = isPointInPolygon(location, locationList2);
            if (isPointInPolygon) {
                return true;
            }
        }
        //判断第二个多边形是否在第一个多边形内
        for (Location location : locationList2) {
            boolean isPointInPolygon = isPointInPolygon(location, locationList);
            if (isPointInPolygon) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPointInPolygon(Location location, List<Location> locationList2) {
        //点是否在多边形内
        GeneralPath path = new GeneralPath();
        //设定多边形起始点
        path.moveTo(locationList2.get(0).getLongitude(), locationList2.get(0).getLatitude());
        for (Location l : locationList2) {
            path.lineTo(l.getLongitude(), l.getLatitude());
        }
        //图像完成，封闭
        path.moveTo(locationList2.get(0).getLongitude(), locationList2.get(0).getLatitude());
        //多边形结束
        path.closePath();
        return path.contains(location.getLongitude(), location.getLatitude());
    }

    private static boolean isIntersect(List<Line> lineList, List<Line> lineList2) {
        for (Line line : lineList) {
            for (Line line1 : lineList2) {
                //两条线段是否相交
                boolean b = Line2D.linesIntersect(line.location1.longitude, line.location1.latitude, line.location2.longitude, line.location2.latitude,
                        line1.location1.longitude, line1.location1.latitude, line1.location2.longitude, line1.location2.latitude);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Line> getLines(List<Location> locationList) {
        List<Line> lineList = new ArrayList();
        for (int i = 0; i < locationList.size(); i++) {
            if (i < locationList.size() - 1) {
                Location l = locationList.get(i);
                Location l2 = locationList.get(i + 1);
                Line line = new Line(l, l2);
                lineList.add(line);
            } else {
                Location l = locationList.get(i);
                Location l2 = locationList.get(0);
                Line line = new Line(l, l2);
                lineList.add(line);
            }
        }
        return lineList;
    }

    //线段
    public static class Line {
        private Location location1;//起点
        private Location location2;//终点

        public Line(Location location1, Location location2) {
            this.location1 = location1;
            this.location2 = location2;
        }

        public Location getLocation1() {
            return location1;
        }

        public void setLocation1(Location location1) {
            this.location1 = location1;
        }

        public Location getLocation2() {
            return location2;
        }

        public void setLocation2(Location location2) {
            this.location2 = location2;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "location1=" + location1 +
                    ", location2=" + location2 +
                    '}';
        }
    }

    //经纬度坐标
    public static class Location {

        private double longitude;//经度
        private double latitude;//纬度

        public Location(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "longitude=" + longitude +
                    ", latitude=" + latitude +
                    '}';
        }
    }

}