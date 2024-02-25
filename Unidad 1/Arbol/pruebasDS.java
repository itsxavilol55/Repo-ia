public class pruebasDS {
    public static void main(String[] args) {
        Arbol arbol1 = new Arbol();
        arbol1.vacia();
        arbol1.insertar(15);
        arbol1.insertar(20);
        arbol1.insertar(30);
        arbol1.insertar(18);
        arbol1.insertar(25);
        arbol1.insertar(28);
        arbol1.insertar(26);
        arbol1.insertar(24);
        arbol1.insertar(27);
        arbol1.insertar(31);
        System.out.println("total: " + arbol1.total(arbol1.getRaiz()));
        System.out.println("inorden");
        arbol1.inorden(arbol1.getRaiz());
        System.out.println();
        System.out.println("posorden");
        arbol1.postorden(arbol1.getRaiz());
        System.out.println();
        System.out.println("preorden");
        arbol1.preorden(arbol1.getRaiz());
        System.out.println("total: " + arbol1.total(arbol1.getRaiz()));
    }
}
