public class puzzApp {
    public static void main(String[] args) {
        String estado = "1234 5678";
        System.out.println("Busqueda por anchura:");

        long inicio = System.currentTimeMillis();
        puz8.BusquedaAnchura(estado);
        long fin = System.currentTimeMillis();
        
        System.out.println("tiempo total: "+(fin-inicio));

        System.out.println("Busqueda por profunfidad:");

        long inicio2 = System.currentTimeMillis();
        puz8.BusquedaProfundidad(estado);
        long fin2 = System.currentTimeMillis();

        System.out.println("tiempo total: "+(fin2-inicio2));
    }
}
