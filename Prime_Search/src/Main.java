import java.util.ArrayList;

public class Main {

    public static void main(String Args[]){

        searcher one = new searcher(0,100000000);
        searcher two = new searcher(100000000,200000000);
        searcher three = new searcher(200000000,300000000);
        searcher four = new searcher(300000000,400000000);
        searcher five = new searcher(400000000,500000000);
        searcher six = new searcher(500000000,600000000);
        searcher seven = new searcher(-100000000,0);

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();
        seven.start();

        ArrayList<Long> onePrimes = one.getPrimes();
        ArrayList<Long> twoPrimes = two.getPrimes();
        ArrayList<Long> threePrimes = three.getPrimes();
        ArrayList<Long> fourPrimes = four.getPrimes();
        ArrayList<Long> fivePrimes = five.getPrimes();
        ArrayList<Long> sixPrimes = six.getPrimes();


        while (six.isAlive()||five.isAlive()||four.isAlive()||three.isAlive()||two.isAlive()||one.isAlive()) {
            onePrimes = one.getPrimes();
            twoPrimes = two.getPrimes();
            threePrimes = three.getPrimes();
            fourPrimes = four.getPrimes();
            fivePrimes = five.getPrimes();
            sixPrimes = six.getPrimes();
        }

        long onePrimesLength = onePrimes.size();
        long twoPrimesLength = twoPrimes.size();
        long threePrimesLength = threePrimes.size();
        long fourPrimesLength = fourPrimes.size();
        long fivePrimesLength = fivePrimes.size();
        long sixPrimesLength = sixPrimes.size();

        long[] lengths = new long[6];
        lengths[0]=onePrimesLength;
        lengths[1]=twoPrimesLength;
        lengths[2]=threePrimesLength;
        lengths[3]=fourPrimesLength;
        lengths[4]=fivePrimesLength;
        lengths[5]=sixPrimesLength;

        double maxLength = getMax(lengths);

        long[] normalizedLengths = new long[6];
        double temp;

        for(int i = 0; i<lengths.length; i++){

            temp=20*(double)lengths[i]/maxLength;
            normalizedLengths[i]=(long)temp;

        }

        System.out.println();

        System.out.println("Histogram of rolls:" );
        printHistogram(normalizedLengths);

    }

    private static void printHistogram(long[] array) {
        for (int range = 0; range < array.length; range++) {
            String label = range + " : ";
            System.out.println(label + convertToStars(array[range]));
        }
    }

    private static String convertToStars(long num) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < num; j++) {
            builder.append('*');
        }
        return builder.toString();
    }

    public static long getMax(long[] inputArray){
        long maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

}
