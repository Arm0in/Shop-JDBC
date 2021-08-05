package ir.maktab.parttwo;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.show();

        list.add("Armin");
        list.add("Akbar");
        list.add("Siamak");
        list.show();

        list.deleteAt(1);
        list.show();
    }
}
