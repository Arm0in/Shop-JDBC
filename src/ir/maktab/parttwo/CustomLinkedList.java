package ir.maktab.parttwo;


public class CustomLinkedList<E> {
    public class Node<E> {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node first;

    public void add(Object data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node currentNode = first;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node currentNode = first;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public int indexOf(Object o) {
        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            if (o.equals(currentNode.data))
                return index;
            currentNode = currentNode.next;
            index++;
        }
        return index;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public void show() {
        Node currentNode = first;
        if(currentNode == null){
            System.out.println("Linked list is empty!");
        }
        else {
            System.out.print("[");
            while(currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println("]");
        }
    }
}
