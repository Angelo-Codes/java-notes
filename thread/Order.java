public class Order {

    public final int id;

    public Order(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "#Oder : " + id;
    }
}
