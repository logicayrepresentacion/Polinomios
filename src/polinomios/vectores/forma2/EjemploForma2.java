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
public class EjemploForma2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //5x5 + 3x3 - 12x + 1
        Termino[] terminosPolinomioA = new Termino[4];
        terminosPolinomioA[0] = new Termino(5, 5);
        terminosPolinomioA[1] = new Termino(3, 3);
        terminosPolinomioA[2] = new Termino(1, -12);
        terminosPolinomioA[3] = new Termino(0, 1);

        // 8x9 - 3x3 + 6x2 + 2
        Termino[] terminosPolinomioB = new Termino[4];
        terminosPolinomioB[0] = new Termino(9, 8);
        terminosPolinomioB[1] = new Termino(3, -3);
        terminosPolinomioB[2] = new Termino(2, 6);
        terminosPolinomioB[3] = new Termino(0, -20);

        PolinomioVectorForma2 polA = new PolinomioVectorForma2(terminosPolinomioA);
        System.out.println(polA.mostrar());

        PolinomioVectorForma2 polB = new PolinomioVectorForma2(terminosPolinomioB);
        System.out.println(polB.mostrar());
        
        PolinomioVectorForma2 polC = polA.sumar(polB);
        System.out.println(polC.mostrar());

    }

}
