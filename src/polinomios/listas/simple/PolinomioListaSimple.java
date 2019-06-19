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
 *
 * @author alejandroescobar
 */
public class PolinomioListaSimple {

    private final Nodo cabeza;

    PolinomioListaSimple() {
        cabeza = new Nodo(null);
        cabeza.setLiga(null);
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public String mostrar() {
        StringBuilder polinomio = new StringBuilder();
        Nodo p = cabeza.getLiga();
        while (!finRecorrido(p)) {
            Termino ti = p.getTermino();
            polinomio.append(ti.getC()).append("X^").append(ti.getE()).append(" ");
            p = p.getLiga();
        }
        return polinomio.toString();
    }

    public int getGrado() {
        Nodo primero = cabeza.getLiga();
        return primero.getTermino().getE();
    }


    public PolinomioListaSimple sumar(PolinomioListaSimple pB) {
        PolinomioListaSimple pC = new PolinomioListaSimple();

        Nodo prA = this.getCabeza().getLiga();
        Nodo prB = this.getCabeza().getLiga();
        Nodo uC = pC.getCabeza();

        while (!finRecorrido(prA) && !finRecorrido(prB)) {
            int eA = prA.getTermino().getE();
            double cA = prA.getTermino().getC();
            int eB = prB.getTermino().getE();
            double cB = prB.getTermino().getC();

            if (eA > eB) { //Traslado datos del Termino de A.
                Termino t = new Termino(eA, cA);
                Nodo n = new Nodo(t);
                prA = prA.getLiga();
                uC.setLiga(n);
                uC = n;
            } else if (eA == eB) {
                double pcC = cA + cB;
                if (pcC != 0) {
                    Termino t = new Termino(eA, pcC);
                    Nodo n = new Nodo(t);
                    uC.setLiga(n);
                    uC = n;
                }
                prA = prA.getLiga();
                prB = prB.getLiga();
            } else {
                Termino t = new Termino(eB, cB);
                Nodo n = new Nodo(t);

                prB = prB.getLiga();
                uC.setLiga(n);
                uC = n;
            }

        }

        while (!finRecorrido(prA)) {
            int eA = prA.getTermino().getE();
            double cA = prA.getTermino().getC();
            Termino t = new Termino(eA, cA);
            Nodo n = new Nodo(t);
            uC.setLiga(n);
            uC = n;
            prA = prA.getLiga();
        }

        while (!finRecorrido(prB)) {
            int eB = prB.getTermino().getE();
            double cB = prB.getTermino().getC();
            Termino t = new Termino(eB, cB);
            Nodo n = new Nodo(t);
            uC.setLiga(n);
            uC = n;
            prB = prB.getLiga();
        }

        return pC;
    }


    public int getCoeficiente(int e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
