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

    public int getGrado() {
        return arreglo[0];
    }

    /**
     * Obtiene el coeficiente dado un exponente
     *
     * @param exp
     * @return coeficiente
     */
    public int getCoeficiente(int exp) {
        int pos = getGrado() - exp + 1;
        return arreglo[pos];
    }

    /**
     * Obtiene el exponente dado una posición
     *
     * @param pos
     * @return exponente
     */
    public int getExponente(int pos) {
        int exp = getGrado() - pos + 1;
        return exp;
    }

    public String mostrar() {
        StringBuilder polinomio = new StringBuilder();
        for (int i = 1; i < arreglo.length; i++) {
            int j = arreglo[i];
            polinomio.append(j).append("X^").append(getExponente(i)).append(" ");
        }
        return polinomio.toString();
    }

    public void setCoeficiente(int c, int e) {
        int pos = getGrado() - e + 1;
        arreglo[pos] = c;
    }

    /**
     * Función para Sumar dos polinomios, entrega un nuevo polinomio resultado
     * de la operación suma.
     *
     * @param polB
     * @return
     */
    public PolinomioVectorForma1 sumar(PolinomioVectorForma1 polB) {

        int gradoA = getGrado();
        int gradoB = polB.getGrado();
        int nGrado = (gradoA > gradoB) ? gradoA : gradoB;
        PolinomioVectorForma1 polC = new PolinomioVectorForma1(nGrado);

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
            while (  i < arreglo.length && arreglo[i] == 0) {
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

}
