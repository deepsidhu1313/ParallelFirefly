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
package parallelfirefly.utils;

import parallelfirefly.datastructure.Firefly;

/**
 *
 * @author nika
 */
public class Util {

    public static Firefly<Integer> encodeToBinary(Firefly firefly, double thresholdForZero) {
        Firefly<Integer> encodedFirefly = new Firefly<>();
        for (int i = 0; i < firefly.length(); i++) {
            Object object = firefly.get(i);
            if ((double) object <= thresholdForZero) {
                encodedFirefly.add(0);
            } else {
                encodedFirefly.add(1);
            }
        }
        return encodedFirefly;
    }
}
