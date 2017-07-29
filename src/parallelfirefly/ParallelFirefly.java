/* 
 * Copyright (C) 2017 Navdeep Singh Sidhu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package parallelfirefly;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import parallelfirefly.datastructure.Firefly;
import parallelfirefly.utils.Util;

/**
 *
 * @author nika
 */
public class ParallelFirefly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Double>> fireflies = new Hashtable<>();
        Hashtable<String, Hashtable<String, Firefly<Double>>> distanceTable = new Hashtable<>();
        String data = Util.readFile("data1.csv");
        String fireflyStrings[] = data.split("\n");
        for (int i = 0; i < fireflyStrings.length; i++) {
            if (i == 0) {
                continue;
            }
            String fireflyString = fireflyStrings[i];
            String fireflyData[] = fireflyString.split(",");

            Firefly<Double> firefly = new Firefly<>("Firefly-" + i);
            for (int j = 0; j < fireflyData.length; j++) {
                String attrib = fireflyData[j];
                if (j == fireflyData.length - 1) {
                    firefly.add(Firefly.HEALTH_STATUS.valueOf(attrib.trim().toUpperCase()));
                } else {
                    firefly.add(Double.parseDouble(attrib.trim()));
                }
            }
            fireflies.put(firefly.getName(), firefly);
        }
//        Enumeration<String> enumKey = fireflies.keys();
//        while (enumKey.hasMoreElements()) {
//
//            String nextElement = enumKey.nextElement();
//            System.out.println("" + fireflies.get(nextElement));
//        }
        for (int i = 0; i < fireflyStrings.length; i++) {
            if (i == 0) {
                continue;
            }
            System.out.println("\tDistance for " + i);
            Hashtable<String, Firefly<Double>> distance = new Hashtable<>();
            for (int j = 0; j < fireflyStrings.length; j++) {
                if (j == 0 || j == i) {
                    continue;
                }
                Firefly<Double> diff = fireflies.get("Firefly-" + i).computeCartesianDistanceofEachAttrib(fireflies.get("Firefly-" + j));
                distance.put("Distance{" + i + ", " + j + "}", diff);
                System.out.println("\t\tDistance{" + i + ", " + j + "}\t" + diff);
            }
            //     System.out.println("Cartesian Distance Between Firefly 1 & Firefly 2\n\t" + fireflies.get("Firefly-1").computeCartesianDistanceofEachAttrib(fireflies.get("Firefly-2")));

            distanceTable.put("Distance-" + i, distance);
        }

    }
}
