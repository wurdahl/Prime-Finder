import java.util.ArrayList;

public class searcher extends Thread {

    long min;
    long max;
    ArrayList<Long> primes = new ArrayList<>();
    boolean done =false;
    boolean prime= true;

    public searcher(long low, long high) {
        min = low;
        max = high;
    }



    public void run(){

        while(!done){

            if((max/2.0)%1==0){
                prime =false;
            }else {

                for (double i = 3; i <= Math.sqrt(max); i += 2) {
                    if (max / i % 1 == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if(prime){
                primes.add(max);

            }

            prime=true;

            max--;

            if(max<min){
                done = true;
            }


        }

        System.out.print(primes+"\n");

    }

    public ArrayList<Long> getPrimes(){
        return primes;
    }

}
