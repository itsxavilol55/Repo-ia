public class puzzAppH {
    public static void main(String[] args) {
        String estado = "1287 3645";
        System.out.println("Busqueda por anchura:");

        long inicio = System.currentTimeMillis();
        puz8H.BusquedaAnchura(estado);
        long fin = System.currentTimeMillis();
        
        System.out.println("tiempo total: "+(fin-inicio));

        System.out.println("Busqueda por profunfidad:");

        long inicio2 = System.currentTimeMillis();
        puz8H.BusquedaProfundidad(estado);
        long fin2 = System.currentTimeMillis();

        System.out.println("tiempo total: "+(fin2-inicio2));
    }
}
