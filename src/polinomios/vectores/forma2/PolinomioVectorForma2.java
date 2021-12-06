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

    public PolinomioVectorForma2() {
        terminos = null;
    }

    /**
     * Obtener el grado del polinomio
     *
     * @return grado del polinomio
     */
    public int getGrado() {
        return terminos[0].getE();
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        boolean primerTermino = true;
        if (terminos == null) {
            return "0";
        }
        for (Termino ti : terminos) {
            double j = ti.getC();
            int i = ti.getE();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
            if (j >= 0) {
                polinomio.append("+");
            }
            polinomio.append(j).append("X^").append(i).append(" ");

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
        int cantidadTerminosA = terminosPolA.length;
        int cantidadTerminosB = terminosPolB.length;
        // Nuevo arreglo para el polinomio resultado polC
        Termino[] terminosPolC = new Termino[cantidadTerminosA + cantidadTerminosB];

        // indices para recorrer
        int indiceC = 0;
        int iRecorridoA = 0;
        int iRecorridoB = 0;

        // Recorrido de A y B en paralelo
        while (iRecorridoA < cantidadTerminosA && iRecorridoB < cantidadTerminosB) {
            // Variables para los datos de cada termino exponente y coeficiente
            int eA = terminosPolA[iRecorridoA].getE();
            double cA = terminosPolA[iRecorridoA].getC();
            int eB = terminosPolB[iRecorridoB].getE();
            double cB = terminosPolB[iRecorridoB].getC();

            if (eA > eB) { //Traslado datos del Termino de A.
                terminosPolC[indiceC] = new Termino(eA, cA);
                iRecorridoA++;
                indiceC++;
            } else if (eA == eB) {
                double posibleCoeficienteC = cA + cB;
                if (posibleCoeficienteC != 0) {
                    terminosPolC[indiceC] = new Termino(eA, posibleCoeficienteC);
                    indiceC++;
                }
                iRecorridoA++;
                iRecorridoB++;
            } else {
                terminosPolC[indiceC] = new Termino(eB, cB);
                iRecorridoB++;
                indiceC++;
            }
        }

        // Recorrer los terminos de A por si no se agoto en el recorrido anterior
        while (iRecorridoA < cantidadTerminosA) {
            // Variables para los datos del termino en A
            int eA = terminosPolA[iRecorridoA].getE();
            double cA = terminosPolA[iRecorridoA].getC();
            terminosPolC[indiceC] = new Termino(eA, cA);
            iRecorridoA++;
            indiceC++;
        }

        // Recorrer los terminos de B por si no se agoto en el recorrido anterior
        while (iRecorridoB < cantidadTerminosB) {
            // Variables para los datos del termino en B
            int eB = terminosPolB[iRecorridoB].getE();
            double cB = terminosPolB[iRecorridoB].getC();
            terminosPolC[indiceC] = new Termino(eB, cB);
            iRecorridoB++;
            indiceC++;
        }

        PolinomioVectorForma2 polC = null;
        // normalizar el arreglo de terminos
        if (indiceC == 0) {
            polC = new PolinomioVectorForma2(null);
            return polC;
        } else {
            if (indiceC < terminosPolC.length) {
                Termino[] terminosCTemporal = new Termino[indiceC];

                System.arraycopy(terminosPolC, 0, terminosCTemporal, 0, indiceC);
                polC = new PolinomioVectorForma2(terminosCTemporal);
                return polC;
            }
        }
        return polC;
    }

    /**
     * 
     * @param c
     * @param e
     * @return 
     */
    public PolinomioVectorForma2 sumarTermino(double c, int e) {

        Termino termino = new Termino(e, c);
        Termino[] terminosC = new Termino[1];
        terminosC[0] = termino;
        PolinomioVectorForma2 polinomioB = new PolinomioVectorForma2(terminosC);

        if (this.terminos == null) {
            return polinomioB;
        } else {
            return this.sumar(polinomioB);
        }

    }

    /**
     * Obtiene el coeficiente de un termino dado un exponente
     *
     * @param exponente
     * @return
     */
    public double getCoeficiente(int exponente) {
        double coeficiente = 0;
        for (Termino t : terminos) {
            if (t.getE() == exponente) {
                return t.getC();
            }
        }
        return coeficiente;
    }

}
