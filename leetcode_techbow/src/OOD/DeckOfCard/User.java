package OOD.DeckOfCard;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<Card> myCards;


    public User(Long id, String name, List<Card> myCards) {
        this.id = id;
        this.name = name;
        this.myCards = myCards;
    }
}
