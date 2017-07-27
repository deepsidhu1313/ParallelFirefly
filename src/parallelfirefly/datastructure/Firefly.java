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

import java.util.ArrayList;

/**
 *
 * @author nika
 */
public class Firefly<T extends Number> extends ArrayList{

   
   
    public Firefly() {

    }

   public int length() {
        return this.size();
    }

    public double computeCartesianDistance(Firefly other) {
        double distance = 0;
        if (other.length() != this.length()) {
            System.err.println("Length Not Same");
            return Double.MIN_VALUE;
        }
        for (int i = 0; i < other.length(); i++) {
            T get = (T) this.get(i);
            T get2 = (T) other.get(i);
             distance += Math.sqrt(Math.pow(get2.doubleValue() - get.doubleValue(),2));
        }
        return distance;
    }

}
