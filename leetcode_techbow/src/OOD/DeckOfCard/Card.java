package OOD.DeckOfCard;

public class Card {
    //花色
    private Enum Suit;
    //数值
    private int value;

    public Card(){}
    public Card(Enum suit, int value) {
        Suit = suit;
        this.value = value;
    }

    public Enum getSuit() {
        return Suit;
    }

    public int getValue() {
        return value;
    }

}
