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
package polinomios.listas.simple;

import polinomios.util.Termino;

/**
 * Clase que representa un polinomio en lista ligada simple con nodo cabeza
 *
 * @author alejandroescobar
 */
public class PolinomioListaSimpleConCabeza {

    private final Nodo cabeza;

    /**
     * Constructor para un polinomio sin terminos
     */
    PolinomioListaSimpleConCabeza() {
        cabeza = new Nodo(null);
        cabeza.setLiga(null);
    }

    /**
     * Obtener el nodo cabeza de la lista
     *
     * @return
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        Nodo p = cabeza.getLiga();
        while (!finRecorrido(p)) {
            Termino ti = p.getTermino();
            double j = ti.getC();
            int i = ti.getE();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
            if (j >= 0) {
                polinomio.append("+");
            }
            polinomio.append(j).append("X^").append(i).append(" ");
            p = p.getLiga();
        }
        return polinomio.toString();
    }

    /**
     * 
     * @return
     * @throws Exception 
     */
    public int getGrado() throws Exception {
        Nodo primero = cabeza.getLiga();
        if (primero == null) {
            return 0;
        }
        return primero.getTermino().getE();
    }

    /**
     * Metodo para sumar dos polinomios, suma el polinomio a con el polinomio b
     * que se pasa como parametros, no se modifica el polinomio a.
     *
     * @param polB polinomio a sumar
     * @return polinomio con el resultado de la suma.
     */
    public PolinomioListaSimpleConCabeza sumar(PolinomioListaSimpleConCabeza polB) {

        //ToDo - Validación de datos
        
        PolinomioListaSimpleConCabeza polC = new PolinomioListaSimpleConCabeza();

        // Variables para los recorridos en polinomios a,b y c
        Nodo nodoRecorridoA = this.getCabeza().getLiga();
        Nodo nodoRecorridoB = polB.getCabeza().getLiga();
        Nodo ultimoNodoC = polC.getCabeza();

        // Recorrido de los terminos en alguna de las dos listas
        while (!finRecorrido(nodoRecorridoA) && !finRecorrido(nodoRecorridoB)) {
            // Variables de exponente y coeficiente de terminos
            int eA = nodoRecorridoA.getTermino().getE();
            double cA = nodoRecorridoA.getTermino().getC();
            int eB = nodoRecorridoB.getTermino().getE();
            double cB = nodoRecorridoB.getTermino().getC();

            if (eA > eB) { //Traslado datos del Termino de A.
                Termino t = new Termino(eA, cA);
                Nodo nuevoNodo = new Nodo(t);
                ultimoNodoC.setLiga(nuevoNodo);
                ultimoNodoC = nuevoNodo;
                nodoRecorridoA = nodoRecorridoA.getLiga(); // recorro la lista polinomio de a
            } else if (eA == eB) { // Opero terminos de a y b
                double posibleCoeficienteC = cA + cB;
                // Si el coeficiente resultado es 0 no se lleva a polinomio c.
                if (posibleCoeficienteC != 0) {
                    Termino t = new Termino(eA, posibleCoeficienteC);
                    Nodo nuevoNodo = new Nodo(t);
                    ultimoNodoC.setLiga(nuevoNodo);
                    ultimoNodoC = nuevoNodo;
                }
                // recorro la lista de polinomio a y b
                nodoRecorridoA = nodoRecorridoA.getLiga();
                nodoRecorridoB = nodoRecorridoB.getLiga();
            } else {
                Termino t = new Termino(eB, cB);
                Nodo nuevoNodo = new Nodo(t);
                ultimoNodoC.setLiga(nuevoNodo);
                ultimoNodoC = nuevoNodo;
                nodoRecorridoB = nodoRecorridoB.getLiga(); // recorro la lista polinomio de b
            }
        }

        // Si la lista de terminos del polinomio B finalizo primero
        while (!finRecorrido(nodoRecorridoB)) {
            // Variables para exponente y coefiente de lista polinomio a
            int eA = nodoRecorridoA.getTermino().getE();
            double cA = nodoRecorridoA.getTermino().getC();
            // Creo el nuevo termino, nuevo nodo y ligo en c
            Termino t = new Termino(eA, cA);
            Nodo n = new Nodo(t);
            ultimoNodoC.setLiga(n);
            ultimoNodoC = n;
            // me sigo moviendo en lista a
            nodoRecorridoA = nodoRecorridoA.getLiga();
        }

        // Si la lista de terminos del polinomio a finalizo primero
        while (!finRecorrido(nodoRecorridoA)) {
            // Variables para exponente y coefiente de lista polinomio a
            int eB = nodoRecorridoB.getTermino().getE();
            double cB = nodoRecorridoB.getTermino().getC();
            // Creo el nuevo termino, nuevo nodo y ligo en c
            Termino t = new Termino(eB, cB);
            Nodo n = new Nodo(t);
            ultimoNodoC.setLiga(n);
            ultimoNodoC = n;
            // me sigo moviendo en lista b
            nodoRecorridoB = nodoRecorridoB.getLiga();
        }

        return polC;
    }

    public double getCoeficiente(int exponente) {
        // Variables para los recorridos en polinomios a,b y c
        Nodo prA = this.getCabeza().getLiga();

        double coeficiente = 0;
        while (!finRecorrido(prA)) {
            if (prA.getTermino().getE() == exponente) {
                return prA.getTermino().getC();
            }
            prA = prA.getLiga();
        }
        return coeficiente;
    }

    public int getDiferentesCero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean finRecorrido(Nodo p) {
        return p == null;
    }

    public void ingresar(double coeficiente, int exponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
