package gamemaster.modal;

public class HintList {

    public static final int FIRST_PRE_DEFINED_TEXT_INDEX = 0;
    public static final int SECOND_PRE_DEFINED_TEXT_INDEX = 1;
    public static final int THIRD_PRE_DEFINED_TEXT_INDEX = 2;
    public static final int FOURTH_PRE_DEFINED_TEXT_INDEX = 3;
    public static final int FIFTH_PRE_DEFINED_TEXT_INDEX = 4;
    public static final int SIXTH_PRE_DEFINED_TEXT_INDEX = 5;
    public static final int SEVENTH_PRE_DEFINED_TEXT_INDEX = 6;
    public static final int EIGHTH_PRE_DEFINED_TEXT_INDEX = 7;
    public static final int NINTH_PRE_DEFINED_TEXT_INDEX = 8;
    public static final int CONGRATS_TEXT_INDEX = 9;
    public static final int HOLO_LENS_TEXT_INDEX = 10;
    public static final int NEURAL_NETWORK_TEXT_INDEX = 11;

    private final String[] preDefinedHints = {
            "You see what the pet robot did? It kept running against obstacle, but then it realized that you should stop in front of stop sign to get through - it learned. That’s why robot pet automatically stopped on the next stop sign. This is machine learning: AI learns by knowing it’s current situation and desired outcome and it solves how to complete the action to reach the outcome. \n" +
                    "\n" +
                    "Näitkö mitä robottilemmikki teki? Se juoksi päin estettä, kunnes ymmärsi että stop-merkin edessä pitää pysähtyä, jotta pääsee ohi - se oppi. Siksi robottilemmikki pysähtyi automaattisesti seuraavalla stop-kyltillä. Tätä kutsutaan koneoppimiseksi: Tekoäly oppii tietämällä nykyisen tilanteen ja halutun lopputuloksen ja se ratkaisee, miten suorittaa tehtävä ja päästä haluttuun lopputulokseen.",
            "You managed to wire Timmy-robot’s brain! That wiring in Timmy’s brain is called Neural network. Neural network is also the very basic structure of AI. So AI is connected networks - wires - that send tons of signals around the network. Wrong signals are discarded and right ones get confirmation. The confirmed signal patterns in neural network are algorithms!\n" +
                    "\n" +
                    "Sait korjattua Timmy-robotin aivot! Nuo eri väriset johdot Timmyn aivoissa ovat nimeltään neuroverkkoja. Neuroverkko on myös tekoälyn perusrakenne. Tekoäly on siis kokoelma yhdistyneitä johtoja - neuroverkkoja - jotka lähettävät valtavan määrän signaaleja toisilleen. Väärät signaalit hylätään ja oikeita vahvistetaan. Vahvistetut signaaliryhmät neuroverkossa ovat itse asiassa algoritmeja!",
            "Hi! I’m your Game Master. I will give you hints if needed. You can follow the time in the bottom.\nHei! Olen pelinohjaajanne. Annan teille tarvittaessa vinkkejä. Voitte seurata aikaa alakulmasta.",
            "What do the glasses show?\nMitä laseista näkyy?",
            "What does the text highlight?\nMitä teksti korostaa?",
            "You may use the paper and pen.\nVoitte käyttää kynää ja paperia avuksi.",
            "Little circle turns.\nPiiri pieni pyörii.",
            "Follow the ready-connected wires and spin.\nSeuraa valmiiksi yhdistettyjä johtoja ja pyöritä.",
            "Spin again and again until ready.\n" +
                    "Pyöritä uudelleen ja uudelleen, kunnes valmista.",
            "Congratulations, you solved the puzzle!\n" +
                    "Onnittelut, olet ratkaissut palapelin!",
            "A=5 L=1 G=9 O=6 R=2 I=8 T=3 H=7 M=4",
            "2-triangle, 3-circle, 2-square, 1-hexagon"
    };

    public String[] getPreDefinedHints() {
        return preDefinedHints;
    }
}
