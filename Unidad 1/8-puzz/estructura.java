import java.util.Queue;
import java.util.Stack;

public class estructura {
    private Queue<String> cola;
    private Stack<String> pila;

    public estructura(Queue<String> cola) {
        this.cola = cola;

    }

    public estructura(Stack<String> pila) {
        this.pila = pila;
    }

    public void add(String inicial) {
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

    public String remove() {
        if (cola != null)
            return cola.poll();
        else
            return pila.pop();
    }
}
