import java.util.Queue;
import java.util.Stack;

public class estructuraH {
    private Queue<nodo> cola;
    private Stack<nodo> pila;

    public estructuraH(Queue<nodo> cola) {
        this.cola = cola;
    }

    public estructuraH(Stack<nodo> pila) {
        this.pila = pila;
    }

    public void add(nodo inicial) {
        if (cola != null)
            cola.add(inicial);
        else
            pila.add(inicial);
    }

    public boolean isEmpty() {
        if (cola != null)
            return cola.isEmpty();
        else
            return pila.isEmpty();
    }

    public nodo remove() {
        if (cola != null)
            return cola.poll();
        else
            return pila.pop();
    }
}
