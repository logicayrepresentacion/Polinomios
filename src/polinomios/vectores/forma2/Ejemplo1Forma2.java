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
package polinomios.vectores.forma2;

import polinomios.util.Termino;

/**
 *
 * @author alejandroescobar
 */
public class Ejemplo1Forma2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // 8x6  + 4x3 – 5
        Termino[] arrPolA = {new Termino(6, 8), new Termino(3, 4), new Termino(0, 5)};
        // 25x2 + 10x + 20
        Termino[] arrPolB = {new Termino(2, 25), new Termino(1, 10), new Termino(0, 20)};

        PolinomioVectorForma2 polA = new PolinomioVectorForma2(arrPolA);
        PolinomioVectorForma2 polB = new PolinomioVectorForma2(arrPolB);

        System.out.println(polA);
        System.out.println(polB);

        PolinomioVectorForma2 polNuevo = polA.sumar(polB);
        System.out.println(polNuevo);
    }

}
