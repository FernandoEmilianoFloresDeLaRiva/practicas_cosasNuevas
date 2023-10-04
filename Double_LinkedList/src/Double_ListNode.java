public class Double_ListNode {
    private int size;
    private Node head, tail;
    public Double_ListNode() {
        this.size = 0;
        this.head=null;
        this.tail=null;
    }
    public void agregarPrincipio(int value){
        Node node= new Node(value);
        node.next=head;
        //Si es el primer elemento agregado head no podra tener un "prev", debido que este seria "null"
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void agregarFinal(int value){
        if(tail==null||head==null){
            agregarPrincipio(value);
            return;
        }
        Node node= new Node(value);
        tail.next=node;
        node.prev=tail;
        tail=node;
        size++;
    }
    public void agregarEnPos(int value, int pos){
        if(pos==0){
            agregarPrincipio(value);
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
        Node nodePrev=conseguirPorPos(pos-1);
        Node nodeTemp=conseguirPorPos(pos);
        Node node= new Node(nodePrev, nodeTemp, value);
        nodePrev.next=node;
        nodeTemp.prev=node;
        size++;
    }
    public void eliminarPorPos(int pos){
        if(pos>=size){
            System.out.println("Esta posicion es inexistente, la ultima posicion agregada es "+(size-1));
            return;
        }
        if(pos==0){
            eliminarPrimerNodo();
            return;
        }
        if (pos==size-1){
            eliminarUltimoNodo();
            return;
        }
        Node nodePrev=conseguirPorPos(pos-1);
        Node nodeNext=conseguirPorPos(pos+1);
        nodePrev.next=nodeNext;
        nodeNext.prev=nodePrev;
        size--;
    }
    public void eliminarPorValor(int value){
        if (verificarValor(value)){
            Node nodeTemp=conseguirNodoPorValor(value);
            if(nodeTemp.value==head.value && nodeTemp.next==head.next){
                eliminarPrimerNodo();
                return;
            }
            if (nodeTemp.value==tail.value && nodeTemp.prev==tail.prev){
                eliminarUltimoNodo();
                return;
            }
            Node nodeNext=nodeTemp.next;
            Node nodePrev=nodeTemp.prev;
            nodePrev.next=nodeNext;
            nodeNext.prev=nodePrev;
            size--;
        }else{
            System.out.println("El valor no esta agregado en la lista");
        }
    }
    public void imprimir(){
        if(size==0){
            System.out.println("La lista no contiene elementos");
            return;
        }
        Node node=head;
        int i=0;
        System.out.println("La lista contiene "+size+" elementos.");
        while(node!=null){
            System.out.println(i+".- "+node.value);
            node=node.next;
            i++;
        }
    }
    public void imprimirReves(){
        if (size==0){
            System.out.println("La lista no contiene elementos");
            return;
        }
        Node node=tail;
        int i=size-1;
        System.out.println("La lista contiene "+size+" elementos.");
        while(node!=null){
            System.out.println(i+".- "+node.value);
            node=node.prev;
            i--;
        }
    }
    public void imprimirSigYPre(){
        Node node=head;
        System.out.println(node.value+" -> "+node.next.value);
        node=node.next;
        while(node.next!=null){
            System.out.println(node.prev.value+" <- "+node.value+" -> "+node.next.value);
            node=node.next;
        }
        System.out.println(tail.prev.value+" <- "+tail.value);
    }
    public void eliminarPrimerNodo(){
        head=head.next;
        head.prev=null;
        size--;
    }
    public void eliminarUltimoNodo(){
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    public Node conseguirPorPos(int pos){
        Node node=head;
        for(int i=0; i<pos; i++){
            node=node.next;
        }
        return node;
    }
    public boolean verificarValor(int value){
        Node nodeValueList=head;
        while (nodeValueList!=null){
            if(nodeValueList.value==value){
                return true;
            }
            nodeValueList=nodeValueList.next;
        }
        return false;
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
    public int getSize() {
        return size;
    }
    public int getHead() {
        return head.value;
    }
    public int getTail() {
        return tail.value;
    }
    private class Node{
        private Node prev, next;
        private int value;
        public Node(int value){
            this.value=value;
        }
        public Node(Node prev, Node next, int value){
            this.prev=prev;
            this.next=next;
            this.value=value;
        }
    }
}