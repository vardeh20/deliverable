package delivrable;
public class UnoCard {
    private String color;
    private String value;

    public UnoCard(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }



    public static void main(String[] args) {
        UnoCard card = new UnoCard("Red", "5");
        System.out.println("Color: " + card.getColor());
        System.out.println("Value: " + card.getValue());
        System.out.println("Card: " + card);
    }
}

