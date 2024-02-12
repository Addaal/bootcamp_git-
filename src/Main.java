import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Main {
//
//    private static final String[] valorNumericoDisplay = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
//
//    public enum ValorNumerico {
//        _A(1), _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), _T(10), _J(11), _Q(12), _K(13);
//        private final int valor;
//
//        ValorNumerico(int valor) {
//            this.valor = valor;
//        }
//
//        public int getValor() {
//            return valor;
//        }
//    }
//
//    private static final String[] palos = {"S", "C", "H", "D"};
//    private static final Random random = new Random();
//
//    public static String generateRandomCard() {
//        String valor = valorNumericoDisplay[random.nextInt(valorNumericoDisplay.length)];
//        String palo = palos[random.nextInt(palos.length)];
//        return valor + palo;
//    }
//
//
//    public static String checkPlay(String[] cards) {
//        int[] valorNumericoArray = new int[5];
//
//        for (int i = 0; i < cards.length; i++) {
//            String valor = "_" + cards[i].charAt(0);
//            ValorNumerico card = ValorNumerico.valueOf(valor);
//            valorNumericoArray[i] = card.getValor();
//        }
//
//
//
//        if (mayorRepeticion(cards, 1, "") == 4) {
//            return "Poker";
//        }
//        if(mayorRepeticion(cards, 0, "") == 3){
//            return "Trio";
//        }
//        if(mayorRepeticion(cards, 0, "Full") == -2){
//            return "Full";
//        }
//        if(mayorRepeticion(cards, 0, "doblePareja") == -3){
//            return "Doble Pareja";
//        }
//        if(mayorRepeticion(cards, 0, "doblePareja") == -4){
//            return "Pareja";
//        }
//        if (mayorRepeticion(cards, 1, "") == 5) {
//            if (checkOrder(valorNumericoArray, "Escalera")) {
//                return "Escalera Color";
//            } else {
//                return "Color";
//            }
//        }
//        if (checkOrder(valorNumericoArray, "")) {
//            return "Escalera";
//        }
//
//
//
//        return "Nada";
//    }
//    public static boolean checkOrder(int[] cardsNumber, String isEscalera) {
//
//        boolean isOrdered = true;
//        Arrays.sort(cardsNumber);
//        boolean Afound = false;
//        boolean Kfound = false;
//        for (int i = 0; i < cardsNumber.length; i++) {
//            if (cardsNumber[i] == 1) {
//                Afound = true;
//            }
//            if (cardsNumber[i] == 13) {
//                Kfound = true;
//            }
//        }
//        if (Afound && Kfound && Objects.equals(isEscalera, "Escalera")) {
//            isOrdered = true;
//            for (int i = 2; i < cardsNumber.length; i++) {
//                if (cardsNumber[i] - cardsNumber[i - 1] != 1) {
//                    isOrdered = false;
//                }
//            }
//        } else {
//
//            for (int i = 1; i < cardsNumber.length; i++) {
//                if (cardsNumber[i] - cardsNumber[i - 1] != 1) {
//                    isOrdered = false;
//                }
//            }
//        }
//        return isOrdered;
//    }
//
//    public static int mayorRepeticion(String[] cards, int index , String jugada) {
//        int mayorRepeticionCount = 0, segundaMayorCount = 0;
//        char characterConMayorRepeticion= 0;
//
//        for (int i = 0; i < cards.length; i++) {
//            int mayorRepeticionHeleper=0;
//            for (int j = 0; j < cards.length; j++) {
//                if (cards[i].charAt(index) == cards[j].charAt(index)) {
//                    mayorRepeticionHeleper += 1;
//                }
//            }
//            if (mayorRepeticionHeleper > mayorRepeticionCount) {
//                mayorRepeticionCount = mayorRepeticionHeleper;
//                characterConMayorRepeticion = cards[i].charAt(index);
//            }
//        }
//        if(Objects.equals(jugada, "Full") && mayorRepeticionCount==3){
//            for (int i = 0; i < cards.length; i++) {
//                if (cards[i].charAt(0) != characterConMayorRepeticion) {
//                    segundaMayorCount += 1;
//                }
//            }
//            if(segundaMayorCount == 2){
//                return -2;
//            }
//        }
//        if(Objects.equals(jugada, "doblePareja") && mayorRepeticionCount==2){
//            for (int i = 0; i < cards.length; i++) {
//                if (cards[i].charAt(0) != characterConMayorRepeticion) {
//                    int segundaMayorCountHelper = 0;
//                    for (int j = 0; j < cards.length; j++) {
//                        if (cards[i].charAt(0) == cards[j].charAt(0)){
//                            segundaMayorCountHelper += 1;
//                        }
//                    }
//                    if(segundaMayorCountHelper > segundaMayorCount){
//                        segundaMayorCount = segundaMayorCountHelper;
//                    }
//                }
//            }
//            if(segundaMayorCount == 2){
//                return -3;
//            }
//            return -4;
//        }
//        return mayorRepeticionCount;
//    }


    public static void main(String[] args) {
        String[] cards = new String[5];

//        for (int i = 0; i < cards.length; i++) {
//            cards[i] = generateRandomCard();
//        }
////        for (int i = 0; i < cards.length; i++) {
////            System.out.print("\t"+cards[i]);
////        }
//        //System.out.println(checkPlay(cards));
////        private static final String[] palos = {"S", "C", "H", "D"};
//        String[] hand = {"3S", "7C", "3S", "AD", "5H"};
//        System.out.println(checkPlay(hand));

    }
}