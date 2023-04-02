package OOD.DeckOfCard;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    //id
    private  Long id ;
    //牌的list
    List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    //methods:
    //发牌
    public Card deal(){
        return cards.remove(cards.size()-1);
    }
    //发num张牌
    public List<Card> deal(int num){
        List<Card> temp = new ArrayList<>();
        for(int i=0;i<num;i++){
            temp.add(deal());
        }
        return temp;
    }
    //洗牌
    public void shuffle(){

    }
}
