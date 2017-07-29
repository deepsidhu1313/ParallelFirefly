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
package parallelfirefly.datastructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author nika
 */
public class Firefly<T extends Number> extends ArrayList implements Serializable {

    public static enum HEALTH_STATUS {
        PD(1), HEALTHY(0);

        private int numVal;

        HEALTH_STATUS(int numVal) {
            this.numVal = numVal;
        }

        public int get() {
            return numVal;
        }
    }

    String name = "FireFly";

    public Firefly() {

    }

    public Firefly(String name) {
        this.name = name;
    }

    public Firefly(T... elements) {
        this.addAll(Arrays.asList(elements));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param name of the firefly
     * @param elements
     */
    public Firefly(String name, T... elements) {
        this.name = name;
        this.addAll(Arrays.asList(elements));
    }

    public int length() {
        return this.size();
    }

    /**
     * *
     *
     * @param other from which to compute distance
     * @return distance
     */
    public double computeCartesianDistance(Firefly other) {
        double distance = 0;
        if (other.length() != this.length()) {
            System.err.println("Length Not Same!! Cannot Compute Cartesian Distance between FireFlies [" + this.name + ", " + other.name + "]");
            return Double.MIN_VALUE;
        }
        for (int i = 0; i < other.length(); i++) {
            if (i < other.length() - 1) {
                T get = (T) this.get(i);
                T get2 = (T) other.get(i);
                double result = get2.doubleValue() - get.doubleValue();
                distance += Math.sqrt(result * result);
            } else {

            }
        }
        return distance;
    }

    /**
     * *
     *
     * @param other from which to compute distance
     * @return distance
     */
    public Firefly<Double> computeCartesianDistanceofEachAttrib(Firefly other) {
        Firefly<Double> distance = new Firefly<>("Distance{" + this.name + ", " + other.name + "}");
        if (other.length() != this.length()) {
            System.err.println("Length Not Same!! Cannot Compute Cartesian Distance between FireFlies [" + this.name + ", " + other.name + "]");
            return null;
        }
        for (int i = 0; i < other.length(); i++) {
            if (i < other.length() - 1) {
                T get = (T) this.get(i);
                T get2 = (T) other.get(i);
                double result = get2.doubleValue() - get.doubleValue();
                distance.add(Math.sqrt(result * result));
            } else {
                distance.add(Firefly.HEALTH_STATUS.PD);
            }
        }
        return distance;
    }

    /**
     * *
     *
     * @param thresholdForZero max value that can be transformed to zero for
     * example : if thresholdForZero is set to 0.7 on a scale for 0.1 to 1.0 All
     * values for less than equal to 0.7 are set 0 and others to 1
     * @return Firefly with encoded values in 0's and 1's
     */
    public Firefly<Integer> encodeToBinary(double thresholdForZero) {
        Firefly<Integer> encodedFirefly = new Firefly<>();
        for (int i = 0; i < this.length(); i++) {
            Object object = this.get(i);
            if ((double) object <= thresholdForZero) {
                encodedFirefly.add(0);
            } else {
                encodedFirefly.add(1);
            }
        }
        return encodedFirefly;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    double W_0= 0.97,gamma=1.0;
        ///
       void Calc(){
           Math.exp(-gamma);
       }
        

}
