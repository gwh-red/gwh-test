package com.gwh;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class img {

    public static void main(String[] args) {

        String[] strings = {
                "https://image.gxptkc.com/upload/1589594802345.jpg",
                "https://image.gxptkc.com/upload/1494032991336.jpg",
                "https://image.gxptkc.com/upload/1592199312129.png",
                "https://image.gxptkc.com/upload/1594720915721.png",
                "https://image.gxptkc.com/upload/1521861484715.jpg",
                "https://image.gxptkc.com/upload/1575977825754.jpg",
                "https://image.gxptkc.com/upload/1559009901099.jpg",
                "https://image.gxptkc.com/upload/1594868353752.png",
                "https://image.gxptkc.com/upload/1595144433263.png",
                "https://image.gxptkc.com/upload/1595144951626.png",
                "https://image.gxptkc.com/upload/1595141689066.jpg",
                "https://image.gxptkc.com/upload/1594799741020.png",
                "https://image.gxptkc.com/upload/1565486719107.png",
                "https://image.gxptkc.com/upload/1570515687253.jpg",
                "https://image.gxptkc.com/upload/1559304812042.jpg",
                "https://image.gxptkc.com/upload/1590210203029.jpg",
                "https://image.gxptkc.com/upload/1596452974546.jpg",
                "https://image.gxptkc.com/upload/1594882780339.jpg",
                "https://image.gxptkc.com/upload/1506775718525.jpg",
                "https://image.gxptkc.com/upload/1575965604461.jpg",
                "https://image.gxptkc.com/upload/1595144361519.png",
                "https://image.gxptkc.com/upload/1559626279938.jpg",
                "https://image.gxptkc.com/upload/1594859850684.png",
                "https://image.gxptkc.com/upload/1595255950127.jpg",
                "https://image.gxptkc.com/upload/1571114462424.jpg",
                "https://image.gxptkc.com/upload/1591415208912.jpg",
                "https://image.gxptkc.com/upload/1591245487701.png",
                "https://image.gxptkc.com/upload/1593617709029.png"};
        List<String> arrayList = Arrays.asList(strings);

        for (int i = 0; i < arrayList.size(); i++) {
            HttpURLConnection urlCon = null;
            try {

                URL realUrl = new URL(arrayList.get(i));
                urlCon = (HttpURLConnection) realUrl.openConnection();

                urlCon.setConnectTimeout(30000);
                urlCon.setReadTimeout(30000);
                urlCon.connect();


                if (urlCon.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    System.out.println(arrayList.get(i));
                }else {
                    System.out.println(1);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(arrayList.get(i));
            }
        }

    }
}
