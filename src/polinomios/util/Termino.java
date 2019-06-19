/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package polinomios.util;

/**
 * Almacenar los datos de un termino en la representación de un polinomio.
 *
 * @author alejandroescobar
 */
public class Termino {

    // Variable para almacenar el exponente
    private int e;
    // Variable para almacenar el coeficiente
    private double c;

    public Termino(int e, double c) {
        this.e = e;
        this.c = c;
    }

    /**
     * Obtener el exponente
     *
     * @return
     */
    public int getE() {
        return e;
    }

    /**
     * Fijar el exponente
     *
     * @param e
     */
    public void setE(int e) {
        this.e = e;
    }

    /**
     * Obtener el Coeficiente del termino
     *
     * @return
     */
    public double getC() {
        return c;
    }

    /**
     * Fijar el coeficiente
     *
     * @param c
     */
    public void setC(double c) {
        this.c = c;
    }

}
