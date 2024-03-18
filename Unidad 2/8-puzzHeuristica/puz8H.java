import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class puz8H {
    static String estadoObjetivo = " 12345678";
    static ArrayList<nodo> sucesoresTotales = new ArrayList<>();
    static List<int[]> movimientos = Arrays.asList(
            new int[] { 1, 3 },
            new int[] { 0, 2, 4 },
            new int[] { 1, 5 },
            new int[] { 0, 4, 6 },
            new int[] { 1, 3, 5, 7 },
            new int[] { 2, 4, 8 },
            new int[] { 3, 7 },
            new int[] { 4, 6, 8 },
            new int[] { 5, 7 });

    public static void BusquedaAnchura(String Inicial) {
        Queue<nodo> cola = new LinkedList<>();
        busqueda(Inicial, new estructuraH(cola));
    }

    public static void BusquedaProfundidad(String Inicial) {
        Stack<nodo> pila = new Stack<>();
        busqueda(Inicial, new estructuraH(pila));
    }

    private static void busqueda(String EstadoInicial, estructuraH estructura) {
        sucesoresTotales.clear();
        nodo Inicial = new nodo(EstadoInicial);
        estructura.add(Inicial);
        sucesoresTotales.add(Inicial);
        while (!estructura.isEmpty()) {
            nodo nodo = estructura.remove();
            ArrayList<nodo> sucesores = getSucesor(nodo);
            for (nodo hijo : sucesores) {
                if (!sucesoresTotales.contains(hijo)) {
                    estructura.add(hijo);
                    sucesoresTotales.add(hijo);
                    if (cumpleObjetivo(hijo.getEstado())) {
                        System.out.println("nodos visitados: " + sucesoresTotales.size());
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<nodo> getSucesor(nodo estadoActual) {
        ArrayList<nodo> sucesores = new ArrayList<>();
        String actual = estadoActual.getEstado();
        int indice = actual.indexOf(" ");// obtiene la posicion donde esta el espacio
        for (int valor : movimientos.get(indice)) {
            String suceso = cambiaEstado(actual, indice, valor);
            // sucesores.add(new nodo(suceso,heuristica1(suceso)));
            sucesores.add(new nodo(suceso,heuristica2(suceso,valor)));
        }
        int mayor=0,indiceMayor=0;
        for (int i = 0; i < sucesores.size(); i++) {
            if(sucesores.get(i).getCosto()>mayor)
            {
                mayor = sucesores.get(i).getCosto();
                indiceMayor = i;
            }
        }
        sucesores.add(0,sucesores.remove(indiceMayor));
        return sucesores;
    }

    private static int heuristica1(String suceso) {//heuristica basada en que tan cercano esta al objetivo
        int costo=0;
        for (int i = 0; i < suceso.length(); i++) 
            if (suceso.charAt(i)==(estadoObjetivo.charAt(i))) 
                costo++;
        return costo;
    }
    private static int heuristica2(String suceso, int valor) {//heuristica basada en peso para cada ficha
        return suceso.charAt(valor);
    }
    private static String cambiaEstado(String estadoActual, int index, int valor) {
        char c1 = estadoActual.charAt(index);
        char c2 = estadoActual.charAt(valor);
        StringBuilder auxSB = new StringBuilder(estadoActual);
        auxSB.setCharAt(index, c2);
        auxSB.setCharAt(valor, c1);
        return "" + auxSB;
    }

    public static boolean cumpleObjetivo(String actual) {
        return actual.equals(estadoObjetivo);
    }

    private static void imprimir(String hijo, int nivel) {
        System.out.println("--" + nivel + "--");
        for (int i = 0; i < hijo.length(); i++) {
            if ((i + 1) % 3 == 0)
                System.out.println(hijo.charAt(i) + " ");
            else
                System.out.print(hijo.charAt(i) + " ");
        }
        System.out.println("-----");
        try {
        Thread.sleep(100); // Retrasa la ejecución durante 1 segundo
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
}