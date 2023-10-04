public class ListaNode {
    private Node head;
    private Node tail;
    private int size;
    public ListaNode() {
        this.size = 0;
    }
    public void agregarPrimero(int value){
        Node node=new Node(value);
        //Decimos que el nodo creado anteriormente su siguiente sera el primero.
        node.next=head;
        //El nodo anteriormente creado pasa a ser el primero
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void agregarFinal(int value){
        if(tail==null||head==null){
            agregarPrimero(value);
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    public void agregarPosEspecifica(int value, int pos) {
        if(pos==0){
            agregarPrimero(value);
            return;
        }
        if(pos==size-1){
            agregarFinal(value);
            return;
        }
        if(pos>=size){
            System.out.println("Esta posicion es inexistente, la ultima posicion agregada es "+(size-1));
            return;
        }
        Node nodePrev=head;
        for (int i=0; i<pos-1; i++){
            nodePrev=nodePrev.next;
        }
        Node node=new Node(value, nodePrev.next);
        nodePrev.next=node;
        size++;
    }
    public void eliminarPorPos(int pos){
        if(pos>=size){
            System.out.println("Esta posicion es inexistente, la ultima posicion agregada es "+(size-1));
            return;
        }
        if(pos==0){
            head=head.next;
            size--;
            return;
        }
        if(pos==size-1){
            Node nodePenultimo= conseguirNodoPorPos(size-2);
            tail=nodePenultimo;
            nodePenultimo.next=null;
            size--;
            return;
        }
        Node nodePrev= conseguirNodoPorPos(pos-1);
        Node nodeTemp= conseguirNodoPorPos(pos);
        nodePrev.next=nodeTemp.next;
        size--;
    }
    public void eliminarPorValor(int value){
        Node nodeValueList=head;
        boolean bandera=false;
        while (nodeValueList!=null){
            if(nodeValueList.value==value){
                bandera=true;
                break;
            }
            nodeValueList=nodeValueList.next;
        }
        if(bandera){
            Node node=conseguirNodoPorValor(value);
            if(node.value== head.value && node.next==head.next){
                head=head.next;
                size--;
                return;
            }
            if(node.value== tail.value && node.next==tail.next){
                Node nodePenultimo= conseguirNodoPorPos(size-2);
                tail=nodePenultimo;
                nodePenultimo.next=null;
                size--;
                return;
            }
            //Se consigue posicion del nodo a eliminar, para posteriormente conseguir la posicion del nodo previo.
            int i=0;
            Node nodeTemp=head;
            while(nodeTemp!=null){
                if (nodeTemp.value==value){
                    break;
                }
                nodeTemp=nodeTemp.next;
                i++;
            }
            Node nodePrev= conseguirNodoPorPos(i-1);
            nodePrev.next=node.next;
            size--;
        }else{
            System.out.println("El valor no esta agregado en la lista");
        }
    }
    public void imprimir(){
        if(size!=0) {
            Node node = head;
            int i = 0;
            System.out.println("Número de elementos en la lista: " + size + "\nElementos en la lista:");
            while (node != null) {
                System.out.println(i + ".- " + node.value);
                node = node.next;
                i++;
            }
        }else{
            System.out.println("Sin elementos en la lista.");
        }
    }
    public int getHead() {
        return head.value;
    }
    public int getTail() {
        return tail.value;
    }
    public int getSize() {
        return size;
    }
    public Node conseguirNodoPorValor(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public Node conseguirNodoPorPos(int pos){
        Node node=head;
        for(int i=0; i<pos; i++){
            node=node.next;
        }
        return node;
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next=next;
        }
    }
}