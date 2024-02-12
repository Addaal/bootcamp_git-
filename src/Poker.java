import java.util.*;

public class Poker {
    private static final String[] valorNumericoDisplay = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    private static final Set<String> generatedCards = new HashSet<>();
    public enum ValorNumerico {
        _A(1), _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), _T(10), _J(11), _Q(12), _K(13);
        private final int valor;

        ValorNumerico(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }
    private static final String[] palos = {"S", "C", "H", "D"};
    private static final Random random = new Random();
    public static String generateRandomCard() {
        String valor;
        String palo;
        String card;

        // Keep generating cards until a non-repeated card is generated
        do {
            valor = valorNumericoDisplay[random.nextInt(valorNumericoDisplay.length)];
            palo = palos[random.nextInt(palos.length)];
            card = valor + palo;
        } while (generatedCards.contains(card));

        // Add the generated card to the set of generated cards
        generatedCards.add(card);

        return card;
    }

    public static String checkPlay(String[] cards) {
        int[] valorNumericoArray = new int[5];
        for (int i = 0; i < cards.length; i++) {
            String valor = "_" + cards[i].charAt(0);
            ValorNumerico card = ValorNumerico.valueOf(valor);
            valorNumericoArray[i] = card.getValor();
        }

        int[] dataFromCards = getDataFromCards(valorNumericoArray, cards);

        if(dataFromCards[4]==1){
            return "Escalera Color";
        }
        if(dataFromCards[0]==4){
            return "Poker";
        }
        if(dataFromCards[0]==3 && dataFromCards[1]==2){
            return "Full";
        }
        if(dataFromCards[2]==5){
            return "Color";
        }
        if(dataFromCards[5]==1){
            return "Escalera";
        }
        if(dataFromCards[0]==3 && dataFromCards[1]==1){
            return "Trio";
        }
        if(dataFromCards[0]==2 && dataFromCards[1]==2){
            return "Par Doble";
        }
        if(dataFromCards[0]==2 && dataFromCards[1]==1){
            return "Doble";
        }
        return "Carta Alta";
    }
    private static int[] getDataFromCards(int[] valorNumericoArray, String[] cards) {
        int mayorRepeticionValor=0;
        int segundaMayorRepeticionValor=0;
        int mayorRepeticionPalo=0;
        int segundaMayorRepeticionPalo=0;
        int esEscaleraColor = 0;
        int esEscalera = 0;
        char characterConMayorRepeticionValor= 0;
        char characterConMayorRepeticionPalo= 0;


        for (int i = 0; i < cards.length; i++) {
            int mayorRepeticionHeleperValor=0, mayorRepeticionHeleperPalo=0;

            for (int j = 0; j < cards.length; j++) {
                if (cards[i].charAt(0) == cards[j].charAt(0)) {
                    mayorRepeticionHeleperValor += 1;
                }
                if (cards[i].charAt(1) == cards[j].charAt(1)) {
                    mayorRepeticionHeleperPalo += 1;
                }
            }
            if (mayorRepeticionHeleperValor > mayorRepeticionValor) {
                mayorRepeticionValor = mayorRepeticionHeleperValor;
                characterConMayorRepeticionValor = cards[i].charAt(0);
            }
            if (mayorRepeticionHeleperPalo > mayorRepeticionPalo) {
                mayorRepeticionPalo = mayorRepeticionHeleperPalo;
                characterConMayorRepeticionPalo = cards[i].charAt(1);
            }
        }

        for(int i=0 ; i<cards.length; i++) {
            if(cards[i].charAt(0) != characterConMayorRepeticionValor){
                int segundaMayorCountHelperValor = 0;
                for (int j = 0; j < cards.length; j++) {
                    if (cards[i].charAt(0) == cards[j].charAt(0)) {
                        segundaMayorCountHelperValor += 1;
                    }
                    if(segundaMayorCountHelperValor > segundaMayorRepeticionValor) {
                        segundaMayorRepeticionValor = segundaMayorCountHelperValor;
                    }
                }
            }

            if(cards[i].charAt(1) != characterConMayorRepeticionPalo){
                int segundaMayorCountHelperPalo = 0;
                for (int j = 0; j < cards.length; j++) {
                    if (cards[i].charAt(1) == cards[j].charAt(1)) {
                        segundaMayorCountHelperPalo += 1;
                    }
                    if(segundaMayorCountHelperPalo > segundaMayorRepeticionPalo) {
                        segundaMayorRepeticionPalo = segundaMayorCountHelperPalo;
                    }
                }
            }
        }
        if(mayorRepeticionPalo == 5){
            if(checkOrder(valorNumericoArray , "Escalera")){
                esEscaleraColor = 1;
            }
        }
        if(checkOrder(valorNumericoArray , "")){
            esEscalera = 1;
        }


        int[] data = {mayorRepeticionValor, segundaMayorRepeticionValor , mayorRepeticionPalo , segundaMayorRepeticionPalo , esEscaleraColor , esEscalera };
        return data;
    }
    public static boolean checkOrder(int[] cardsNumber, String isEscalera) {

        boolean isOrdered = true;
        Arrays.sort(cardsNumber);
        boolean Afound = false;
        boolean Kfound = false;
        for (int i = 0; i < cardsNumber.length; i++) {
            if (cardsNumber[i] == 1) {
                Afound = true;
            }
            if (cardsNumber[i] == 13) {
                Kfound = true;
            }
        }
        if (Afound && Kfound && Objects.equals(isEscalera, "Escalera")) {
            isOrdered = true;
            for (int i = 2; i < cardsNumber.length; i++) {
                if (cardsNumber[i] - cardsNumber[i - 1] != 1) {
                    isOrdered = false;
                }
            }
        } else {

            for (int i = 1; i < cardsNumber.length; i++) {
                if (cardsNumber[i] - cardsNumber[i - 1] != 1) {
                    isOrdered = false;
                }
            }
        }
        return isOrdered;
    }



    public static void main(String[] args) {
        String[] cards = new String[5];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = generateRandomCard();
        }
        for (int i = 0; i < cards.length; i++) {
            System.out.print("\t"+cards[i]);
        }
        System.out.println("\n"+checkPlay(cards));

//        String[] hand = {"AH", "AC", "AS", "7H", "7C"};
//        System.out.println(checkPlay(hand));

    }
}
