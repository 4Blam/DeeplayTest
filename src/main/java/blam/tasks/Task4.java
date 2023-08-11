package blam.tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task4 implements Solvable{
    private final int K;
    private int L;
    private int N;
    private final int[] array;
    private Vector<Integer> answer;
    private boolean found;
    public Task4(){
        this.K = 2;
        this.array = new int[]{10, 11, 7, 7, 12};
        this.N = this.array.length;
        this.answer = new Vector<>(N);
    }
    public Task4(int[] array, int K){
        this.K = K;
        this.array = array;
        this.N = array.length;
        this.answer = new Vector<>(N);
    }
    void findAllSubsets(ArrayList<Integer> arrayList, Vector<Integer> answer, int sum, int step){
        if((sum == 0) && (step == K-1) && (arrayList.size() == 0)){
            if(found){
                return;
            }else{
                found = true;
                for(int i = 0; i < answer.size(); i++){
                    this.answer.add(answer.get(i));
                }
            }
            return;
        }
        if(sum==0){
            step++;
            sum = L + step;
            findAllSubsets(arrayList, answer, sum, step);
        }
        if(arrayList.size()==0){
            return;
        }
        int value;
        for(int q = 0; q < arrayList.size(); q++){
            value = arrayList.get(q);
            if(value <= sum) {
                answer.add(value);
                arrayList.remove(q);
                findAllSubsets(arrayList, answer, sum - value, step);
                arrayList.add(value);
                answer.remove(answer.size() - 1);
            }
        }
        return;
    }
    @Override
    public void solve() {
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            sum+=array[i];
        }
        //Вычислим L через сумму арифмитечской прогрессии
        double result = (2*sum + K - Math.pow(K,2)) / (2*K);

        //Если оно не целое - ошибка
        if(result%1 == 0){
            L=(int) result;
        }else {
            System.out.println("невозможно");
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            arrayList.add(array[i]);
        }

        int step = 0;
        Vector<Integer> answerCombination = new Vector<>();
        findAllSubsets(arrayList, answerCombination, L, step);
        if(answer.size() == 0){
            System.out.println("\nневозможно");
        }else {
            int currNeededSum = L;
            int currSum = 0;
            System.out.print("\n[");
            for (int i = 0; i < answer.size() - 1; i++) {
                currSum += answer.get(i);
                if (currSum == currNeededSum) {
                    System.out.print(answer.get(i) + "], " + currNeededSum + ", [");
                    currSum = 0;
                    currNeededSum++;
                } else {
                    System.out.print(answer.get(i) + ", ");
                }
            }
            System.out.print(answer.get(answer.size() - 1) + "], " + currNeededSum + "\n");
        }
    }

}
