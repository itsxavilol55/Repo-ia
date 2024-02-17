import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class puz8 {
    static String estadoInicial = "7245 6831";
    static String estadoObjetivo = " 12345678";
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
    static ArrayList<String> sucesoresTotales = new ArrayList<>();

    public static void BusquedaAnchura(String Inicial) {

    }

    public static void BusquedaProfundidad(String Inicial) {

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

    public static void getMejorOpcion(ArrayList<String> sucesores) {
        for (String actual : sucesores) {
            int cont=0;
            for (int i = 0; i < actual.length(); i++) {
                if (actual.charAt(i)==estadoObjetivo.charAt(i)) {
                    cont++;
                }
            }
            try {
                Thread.sleep(100); // Retrasa la ejecución durante 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!sucesoresTotales.contains(actual)) {
                System.out.println(actual);
                sucesoresTotales.add(actual);
                getMejorOpcion(getSucesor(actual));
            }
        }
    }

    public static boolean cumpleObjetivo(String actual) {
        return actual.equals(estadoObjetivo);
    }

}