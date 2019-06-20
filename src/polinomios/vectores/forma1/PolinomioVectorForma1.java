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
package polinomios.vectores.forma1;

/**
 *
 * @author alejandroescobar
 */
public class PolinomioVectorForma1 {

    private int[] arreglo;

    /**
     * Constructor que crea un arreglo sin coeficientes de grado n
     *
     * @param n es el grado
     */
    public PolinomioVectorForma1(int n) {
        arreglo = new int[n + 2];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
        arreglo[0] = n;
    }

    /**
     * Para realizar pruebas
     *
     * @param arreglo
     */
    public PolinomioVectorForma1(int[] arreglo) {
        this.arreglo = arreglo;
    }

    /**
     * Constructor que cree un arreglo sin coeficiente
     */
    PolinomioVectorForma1() {

    }

    public int getGrado() throws Exception {
        if (arreglo != null) {
            return arreglo[0];
        } else {
            throw new NullPointerException("El arreglo esta nulo");
        }
    }

    /**
     * Obtiene el coeficiente dado un exponente
     *
     * @param exp
     * @return coeficiente
     * @throws java.lang.Exception
     */
    public int getCoeficiente(int exp) throws Exception {
        int pos = getGrado() - exp + 1;
        return arreglo[pos];
    }

    /**
     * Obtiene el exponente dado una posición
     *
     * @param pos
     * @return exponente
     * @throws java.lang.Exception
     */
    public int getExponente(int pos) throws Exception {
        int exp = getGrado() - pos + 1;
        return exp;
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        try {
            for (int i = 1; i < arreglo.length; i++) {
                int j = arreglo[i];
                polinomio.append(j).append("X^").append(getExponente(i)).append(" ");
            }
        } catch (Exception e) {
            polinomio.append("El arreglo estaba NULO");
        }
        return polinomio.toString();
    }

    public void setCoeficiente(int c, int e) throws Exception {
        int pos = getGrado() - e + 1;
        arreglo[pos] = c;
    }

    /**
     * Función para Sumar dos polinomios, entrega un nuevo polinomio resultado
     * de la operación suma.
     *
     * @param polB
     * @return
     * @throws java.lang.Exception
     */
    public PolinomioVectorForma1 sumar(PolinomioVectorForma1 polB) throws Exception {

        PolinomioVectorForma1 polC;

        if (polB == null) {
            throw new Exception("el polinomio b es null");
        }

        // Bloque para validar si los arreglos son nulos o no
        int[] arrB = polB.getArreglo();
        if (arrB == null) {
            if (arreglo == null) {
                polC = new PolinomioVectorForma1();
            } else {
                int[] arregloNuevo = new int[arreglo.length];
                System.arraycopy(arreglo, 0, arregloNuevo, 0, arreglo.length);
                polC = new PolinomioVectorForma1(arregloNuevo);
                return polC;
            }
        } else {
            if (arreglo == null) {
                int[] arregloNuevo = new int[arrB.length];
                System.arraycopy(arrB, 0, arregloNuevo, 0, arrB.length);
                polC = new PolinomioVectorForma1(arregloNuevo);
                return polC;
            }
        }

        // Este es el caso en que ambos arreglos no son nulos
        int gradoA = getGrado();
        int gradoB = polB.getGrado();
        int nGrado = (gradoA > gradoB) ? gradoA : gradoB;
        polC = new PolinomioVectorForma1(nGrado);

        int e = 0;
        while (e <= gradoA && e <= gradoB) {
            int nC = getCoeficiente(e) + polB.getCoeficiente(e);
            polC.setCoeficiente(nC, e);
            e++;
        }

        while (e <= gradoA) {
            polC.setCoeficiente(getCoeficiente(e), e);
            e++;
        }

        while (e <= gradoB) {
            polC.setCoeficiente(polB.getCoeficiente(e), e);
            e++;
        }

        polC.normalizar();
        return polC;
    }

    public int getDiferentesCero() {
        return 0;
    }

    public int[] getArreglo() {
        return arreglo;
    }

    public void ingresar(double coeficiente, int exponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Permite validar el arreglo y garantizar que no tenga terminos iniciales
     * en 0
     *
     */
    private void normalizar() {

        // Si la primera posición es 0
        if (arreglo[1] == 0) {
            int i = 1;
            while (i < arreglo.length && arreglo[i] == 0) {
                i++;
            }
            if (i < arreglo.length) {
                int nuevoGrado = i - 1;
                int nuevoArreglo[] = new int[nuevoGrado + 2];
                nuevoArreglo[0] = nuevoGrado;
                System.arraycopy(arreglo, i, nuevoArreglo, 1, arreglo.length - i);
                arreglo = nuevoArreglo;
            } else {
                arreglo = new int[1];
                arreglo[0] = -1;
            }
        }
    }

    /**
     * Sumar al polinomio a (this) un termino, la estrategia es crear un
     * polinomio b de un solo termino y luego sumar a y b
     *
     * @param exponente
     * @param coeficiente
     * @return
     * @throws Exception
     */
    public PolinomioVectorForma1 sumar(int exponente, int coeficiente) throws Exception {
        PolinomioVectorForma1 polB;
        if (coeficiente != 0) {
            /**
             * El tamaño del arreglo es de grado n + 2, como el polinomio
             * resultante va a ser de un solo termino, el grado es el mismo
             * exponente
             */
            int[] arregloPol = new int[exponente + 2];
            for (int i = 0; i < arregloPol.length; i++) {
                arregloPol[i] = 0;
            }
            arregloPol[0] = exponente;
            arregloPol[1] = coeficiente;
            polB = new PolinomioVectorForma1(arregloPol);
        } else {
            polB = new PolinomioVectorForma1();
        }
        return this.sumar(polB);

    }

}
