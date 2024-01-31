public class Arbol {
    private nodoArbol raiz;
    private nodoArbol padre;
    private int total;

    public Arbol() {
        raiz = null;
        padre = null;
        total = 0;
    }

    public void insertar(int dato) {
        nodoArbol nodo = new nodoArbol(dato);
        if (raiz == null) {
            raiz = nodo;
            return;
        }
        insert(dato, raiz, nodo);
    }

    private void insert(int dato, nodoArbol nodoAux, nodoArbol nodo) {
        if (dato == nodoAux.getDato())
            return;
        if (dato < nodoAux.getDato() && nodoAux.getIzquierdo() == null) {
            nodoAux.setIzquierdo(nodo);
            nodoAux.setTieneHijos(true);
            return;
        }
        if (dato < nodoAux.getDato() && nodoAux.getIzquierdo() != null) {
            insert(dato, nodoAux.getIzquierdo(), nodo);
            nodoAux.setTieneHijos(true);
            return;
        }
        if (dato > nodoAux.getDato() && nodoAux.getDerecho() == null) {
            nodoAux.setDerecho(nodo);
            nodoAux.setTieneHijos(true);
            return;
        } else
            insert(dato, nodoAux.getDerecho(), nodo);
        nodoAux.setTieneHijos(true);
    }

    public nodoArbol getRaiz() {
        return raiz;
    }

    private void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }

    public void inorden(nodoArbol nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            inorden(nodo.getDerecho());
        }
    }

    public void preorden(nodoArbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());
            inorden(nodo.getIzquierdo());
            inorden(nodo.getDerecho());
        }
    }

    public void postorden(nodoArbol nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            inorden(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }

    public nodoArbol buscar(int dato, nodoArbol nodoAux) {
        if (nodoAux == null)
            return null;
        if (dato != nodoAux.getDato()) {
            padre = nodoAux;
            if (dato < nodoAux.getDato())
                return buscar(dato, nodoAux.getIzquierdo());
            else
                return buscar(dato, nodoAux.getDerecho());
        }
        if (dato == raiz.getDato())
            return raiz;
        return padre;
    }

    public void borrar(int dato) {
        nodoArbol nodoAux = buscar(dato, raiz);
        if (nodoAux == null) {
            System.out.println("no se encontro el elemento");
            return;
        }
        if (dato == raiz.getDato()) {
            if (!nodoAux.isTieneHijos()) {
                raiz = null;
                return;
            }
            if (nodoAux.getIzquierdo() == null && nodoAux.getDerecho() != null)
                raiz = nodoAux.getDerecho();
            else if (nodoAux.getIzquierdo() != null && nodoAux.getDerecho() == null)
                raiz = nodoAux.getIzquierdo();
            if (nodoAux.getIzquierdo() != null && nodoAux.getDerecho() != null) {
                nodoArbol nuevaRaiz = mayorDeMenores(nodoAux);
                nodoArbol padre = buscar(nuevaRaiz.getDato(), raiz);
                padre.setDerecho(nuevaRaiz.getIzquierdo());
                nuevaRaiz.setIzquierdo(nodoAux.getIzquierdo());
                nuevaRaiz.setDerecho(nodoAux.getDerecho());
                raiz = nuevaRaiz;
            }
            nodoAux.setDerecho(null);
            nodoAux.setIzquierdo(null);
            return;
        }
        if (dato < nodoAux.getDato()) {
            if (nodoAux.getIzquierdo().isTieneHijos()) {
                if (nodoAux.getIzquierdo().getIzquierdo() == null)
                    nodoAux.setIzquierdo(nodoAux.getIzquierdo().getDerecho());
                else if (nodoAux.getIzquierdo().getDerecho() == null)
                    nodoAux.setIzquierdo(nodoAux.getIzquierdo().getIzquierdo());
            } else {
                nodoAux.setIzquierdo(null);
                if (nodoAux.getDerecho() == null)
                    nodoAux.setTieneHijos(false);
                return;
            }
            if (nodoAux.getIzquierdo().getIzquierdo() != null && nodoAux.getIzquierdo().getDerecho() != null) {
                nodoArbol nodoBorrar = nodoAux.getIzquierdo();
                nodoArbol nodoMenor = mayorDeMenores(nodoBorrar);
                nodoArbol padreMenor = buscar(nodoMenor.getDato(), raiz);
                nodoArbol hijoMenor = nodoMenor.getIzquierdo();
                if (nodoBorrar.getIzquierdo() == nodoMenor)
                    nodoMenor.setIzquierdo(nodoMenor.getIzquierdo());
                else
                    nodoMenor.setIzquierdo(nodoBorrar.getIzquierdo());
                nodoMenor.setDerecho(nodoBorrar.getDerecho());
                nodoBorrar.setIzquierdo(null);
                nodoBorrar.setDerecho(null);
                padreMenor.setDerecho(hijoMenor);
                nodoAux.setIzquierdo(nodoMenor);
            }
            return;
        } else {
            if (nodoAux.getDerecho().isTieneHijos()) {
                if (nodoAux.getDerecho().getIzquierdo() == null && nodoAux.getDerecho().getDerecho() != null)
                    nodoAux.setDerecho(nodoAux.getDerecho().getDerecho());
                else if (nodoAux.getDerecho().getDerecho() == null && nodoAux.getDerecho().getIzquierdo() != null)
                    nodoAux.setDerecho(nodoAux.getDerecho().getIzquierdo());
            } else {
                nodoAux.setDerecho(null);
                if (nodoAux.getIzquierdo() == null)
                    nodoAux.setTieneHijos(false);
                return;
            }
            if (nodoAux.getDerecho().getIzquierdo() != null && nodoAux.getDerecho().getDerecho() != null) {
                nodoArbol nodoBorrar = nodoAux.getDerecho();
                nodoArbol nodoMenor = mayorDeMenores(nodoBorrar);
                nodoArbol padreMenor = buscar(nodoMenor.getDato(), raiz);
                nodoArbol hijoMenor = nodoMenor.getIzquierdo();
                if (nodoBorrar.getIzquierdo() == nodoMenor)
                    nodoMenor.setIzquierdo(nodoMenor.getIzquierdo());
                else
                    nodoMenor.setIzquierdo(nodoBorrar.getIzquierdo());//
                nodoMenor.setDerecho(nodoBorrar.getDerecho());
                nodoBorrar.setIzquierdo(null);
                nodoBorrar.setDerecho(null);
                padreMenor.setDerecho(hijoMenor);
                nodoAux.setDerecho(nodoMenor);
            }
        }
    }

    public nodoArbol mayorDeMenores(nodoArbol nodo) {
        nodo = nodo.getIzquierdo();
        while (nodo.getDerecho() != null)
            nodo = nodo.getDerecho();
        return nodo;
    }

    public int total(nodoArbol nodo) {
        total = 0;
        total = totalReal(nodo);
        return total;
    }

    private int totalReal(nodoArbol nodo) {
        if (nodo != null) {
            total++;
            totalReal(nodo.getIzquierdo());
            totalReal(nodo.getDerecho());
        }
        return total;
    }

    public nodoArbol menorDeMayores(nodoArbol nodo) {
        nodo = nodo.getDerecho();
        while (nodo.getIzquierdo() != null)
            nodo = nodo.getIzquierdo();
        return nodo;
    }

    public void vacia() {
        if (raiz == null)
            System.out.println("esta vacia");
        else
            System.out.println("no esta vacia");
    }

    public void vaciar() {
        raiz = null;
    }
}
