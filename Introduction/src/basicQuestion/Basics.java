package basicQuestion;

public class Basics {
    public static void main(String[] args){
        System.out.println(SumOfnNaturalNumbers(5));

        System.out.println(SumOfNaturalNumbers.Fun1(5));
    }


    static int SumOfnNaturalNumbers(int n){
        return n*(n+1)/2;
    }

}


class SumOfNaturalNumbers{
    static int Fun1(int n){
        int sum = 0;
        for(int idx = 1 ; idx<=n ; idx++){
            sum = sum + idx;
        }
        return sum;
    }
}
