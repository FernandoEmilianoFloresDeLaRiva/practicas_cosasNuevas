import java.util.Scanner;
public class Main {
    static Scanner entrada=new Scanner(System.in);
    static ListaNode Lista=new ListaNode();
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("1.- Agregar elemento al principio\n2.- Agregar elemento al final\n3.- Agregar elemento en" +
                " posicion especifica\n4.- Eliminar elemento por posicion\n5- Eliminar elemento por valor\n" +
                "6.- Imprimir elementos\n7.- Imprimir primer y ultimo elemento\n8.- Salir");
        switch (entrada.nextInt()){
            case 1:
                System.out.println("Digite valor a agregar:");
                Lista.agregarPrimero(entrada.nextInt());
                System.out.println();
                menu();
                break;
            case 2:
                System.out.println("Digite valor a agregar:");
                Lista.agregarFinal(entrada.nextInt());
                System.out.println();
                menu();
                break;
            case 3:
                System.out.println("Digite valor a agregar:");
                int value= entrada.nextInt();
                System.out.println("Digite posicion en que se agregara el valor: ");
                int pos= entrada.nextInt();
                Lista.agregarPosEspecifica(value, pos);
                System.out.println();
                menu();
                break;
            case 4:
                System.out.println("Digite posicion a eliminar:");
                Lista.eliminarPorPos(entrada.nextInt());
                System.out.println();
                menu();
                break;
            case 5:
                System.out.println("Digite valor a eliminar:");
                Lista.eliminarPorValor(entrada.nextInt());
                System.out.println();
                menu();
                break;
            case 6:
                Lista.imprimir();
                System.out.println();
                menu();
                break;
            case 7:
                if(Lista.getSize()!=0){
                    System.out.println("Su primer elemento es "+Lista.getHead()+"\nSu ultimo elemento es "+Lista.getTail());
                }else{
                    System.out.println("No hay elementos existentes");
                }
                menu();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                menu();
        }
    }
}