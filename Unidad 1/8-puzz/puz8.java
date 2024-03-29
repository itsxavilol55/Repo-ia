import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class puz8 {
    static String estadoObjetivo = " 12345678";
    static ArrayList<String> sucesoresTotales = new ArrayList<>();
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
        Queue<String> cola = new LinkedList<>();
        busqueda(Inicial, new estructura(cola));
    }

    public static void BusquedaProfundidad(String Inicial) {
        Stack<String> pila = new Stack<>();
        busqueda(Inicial, new estructura(pila));
    }

    private static void busqueda(String Inicial, estructura estructura) {
        sucesoresTotales.clear();
        estructura.add(Inicial);
        sucesoresTotales.add(Inicial);
        while (!estructura.isEmpty()) {
            String nodo = estructura.remove();
            ArrayList<String> sucesores = getSucesor(nodo);
            for (String hijo : sucesores) {
                if (!sucesoresTotales.contains(hijo)) {
                    estructura.add(hijo);
                    sucesoresTotales.add(hijo);
                    if (cumpleObjetivo(hijo)) {
                        System.out.println("nodos visitados: " + sucesoresTotales.size());
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<String> getSucesor(String estadoActual) {
        ArrayList<String> sucesores = new ArrayList<>();
        int indice = estadoActual.indexOf(" ");// obtiene la posicion donde esta el espacio
        for (int valor : movimientos.get(indice)) {
            String suceso = cambiaEstado(estadoActual, indice, valor);
            sucesores.add(suceso);
        }
        return sucesores;
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
        // try {
        // Thread.sleep(100); // Retrasa la ejecución durante 1 segundo
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
    }
}