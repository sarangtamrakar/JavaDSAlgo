public class AnalysisOfAlgoritms {
    public static void main(String[] args){
        System.out.println(sumOfNNaturalNumbers(5));
    }

    static int sumOfNNaturalNumbers(int n){
        int sum = 0;
        for(int i = 1 ; i <=n ; i++) {
            sum += i;
        }
        return sum;
        }
}

