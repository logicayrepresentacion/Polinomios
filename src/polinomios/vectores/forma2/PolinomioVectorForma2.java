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
public class PolinomioVectorForma2 {

    private final Termino[] terminos;

    /**
     * Constructor para el polinomio
     *
     * @param terminos arreglo de terminos del polinomios
     */
    public PolinomioVectorForma2(Termino[] terminos) {
        this.terminos = terminos;
    }

    /**
     * Obtener el grado del polinomio
     *
     * @return grado del polinomio
     */
    public int getGrado() {
        return terminos[0].getE();
    }

    public String mostrar() {
        StringBuilder polinomio = new StringBuilder();
        for (Termino ti : terminos) {
            polinomio.append(ti.getC()).append("X^").append(ti.getE()).append(" ");
        }
        return polinomio.toString();
    }

    /**
     * Obtener el arreglo de terminos del polinomio
     *
     * @return
     */
    public Termino[] getTerminos() {
        return terminos;
    }

    /**
     * Cantidad de terminos diferentes de coeficiente 0 en el polinomio
     *
     * @return
     */
    public int getDiferentesCero() {
        return this.terminos.length;
    }

    /**
     * Función para Sumar dos polinomios, entrega un nuevo polinomio resultado
     * de la operación suma.
     *
     * @param polB Es una instancia de un polinomio representado en forma 2.
     * @return
     */
    public PolinomioVectorForma2 sumar(PolinomioVectorForma2 polB) {
        // Variables para manipular los terminos
        Termino[] terminosPolB = polB.getTerminos();
        Termino[] terminosPolA = terminos;
        // Cantidades de terminos diferentes de cero
        int ctA = terminosPolA.length;
        int ctB = terminosPolB.length;
        // Nuevo arreglo para el polinomio resultado polC
        Termino[] terminosPolC = new Termino[ctA + ctB];
        PolinomioVectorForma2 polC = new PolinomioVectorForma2(terminosPolC);
        // indices para recorrer
        int iC = 0;
        int iA = 0;
        int iB = 0;

        // Recorrido de A y B en paralelo
        while (iA < ctA && iB < ctB) {
            // Variables para los datos de cada termino exponente y coeficiente
            int eA = terminosPolA[iA].getE();
            double cA = terminosPolA[iA].getC();
            int eB = terminosPolB[iB].getE();
            double cB = terminosPolB[iA].getC();

            if (eA > eB) { //Traslado datos del Termino de A.
                terminosPolC[iC] = new Termino(eA, cA);
                iA++;
                iC++;
            } else if (eA == eB) {
                double posibleCoeficienteC = cA + cB;
                if (posibleCoeficienteC != 0) {
                    terminosPolC[iC] = new Termino(eA, posibleCoeficienteC);
                    iC++;
                }
                iA++;
                iB++;
            } else {
                terminosPolC[iC] = new Termino(eB, cB);
                iB++;
                iC++;
            }
        }

        // Recorrer los terminos de A por si no se agoto en el recorrido anterior
        while (iA < ctA) {
            // Variables para los datos del termino en A
            int eA = terminosPolA[iA].getE();
            double cA = terminosPolA[iA].getC();
            terminosPolC[iC] = new Termino(eA, cA);
            iA++;
            iC++;
        }

        // Recorrer los terminos de B por si no se agoto en el recorrido anterior
        while (iB < ctB) {
            // Variables para los datos del termino en B
            int eB = terminosPolB[iB].getE();
            double cB = terminosPolB[iA].getC();
            terminosPolC[iC] = new Termino(eB, cB);
            iB++;
            iC++;
        }

        // normalizar el arreglo de terminos
        if (iC == 0) {
            polC = new PolinomioVectorForma2(null);
            return polC;
        } else {
            if (iC < terminosPolC.length) {
                Termino[] terminosCTemporal = new Termino[iC];

                // Una opción es copiar registro a registro 
                // for (int i = 0; i < iC; i++) { 
                //  terminosCTemporal[i] = terminosPolC[i]; 
                // }
                
                System.arraycopy(terminosPolC, 0, terminosCTemporal, 0, iC);
                polC = new PolinomioVectorForma2(terminosCTemporal);
                return polC;
            }
        }
        return polC;
    }

}
