import java.util.Scanner;
public class Main {
    static Double_ListNode Lista=new Double_ListNode();
    static Scanner entrada=new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("""
                1.- Agregar elemento al principio
                2.- Agregar elemento al final
                3.- Agregar elemento en posicion especifica
                4.- Eliminar elemento por posicion
                5.- Eliminar elemento por valor
                6.- Imprimir elementos
                7.- Imprimir elementos al reves
                8.- Imprimir primer y ultimo elemento
                9.- Imprimir elementos (Indicando su elemento previo y siguiente)
                10.- Salir""");
        switch (entrada.nextInt()) {
            case 1 -> {
                System.out.println("Ingrese valor a agregar");
                Lista.agregarPrincipio(entrada.nextInt());
                menu();
            }
            case 2 -> {
                System.out.println("Ingrese valor a agregar:");
                Lista.agregarFinal(entrada.nextInt());
                menu();
            }
            case 3 -> {
                System.out.println("Ingrese valor a agregar:");
                int value = entrada.nextInt();
                System.out.println("Ingrese la posicion en que se insertara: ");
                int pos = entrada.nextInt();
                Lista.agregarEnPos(value, pos);
                menu();
            }
            case 4 -> {
                if (Lista.getSize() != 0) {
                    System.out.println("Ingrese posicion a eliminar");
                    Lista.eliminarPorPos(entrada.nextInt());
                } else {
                    System.out.println("Lista vacia, no hay datos a eliminar.");
                }
                menu();
            }
            case 5 -> {
                if (Lista.getSize() != 0) {
                    System.out.println("Ingrese valor a eliminar");
                    Lista.eliminarPorValor(entrada.nextInt());
                } else {
                    System.out.println("Lista vacia, no hay datos a eliminar.");
                }
                menu();
            }
            case 6 -> {
                Lista.imprimir();
                menu();
            }
            case 7 -> {
                Lista.imprimirReves();
                menu();
            }
            case 8 -> {
                if (Lista.getSize() != 0) {
                    System.out.println("Su primer elemento es " + Lista.getHead() + "\nSu ultimo elemento es " + Lista.getTail());
                } else {
                    System.out.println("No hay elementos existentes");
                }
                menu();
            }
            case 9 -> {
                if (Lista.getSize() != 0) {
                    Lista.imprimirSigYPre();
                } else {
                    System.out.println("No hay elementos existentes");
                }
                menu();
            }
            case 10 -> System.exit(0);
            default -> menu();
        }
    }
}