package blam.tasks;

import java.util.Arrays;
import java.util.Collections;

public class Task3 implements Solvable{
    private final int[] firstComb;
    private final int[] secondComb;
    private final int N;
    private int[] diceResults;
    public Task3(){
        this.firstComb = new int[3];
        this.secondComb = new int[3];
        this.N = 1000;
        this.diceResults = new int[N];
    }
    private void fillDiceResults(){
        for(int i = 0; i < N; i++){
            diceResults[i] = 1 + (int) (Math.random() * 6);
        }
    }
    @Override
    public void solve() {
        //Задать комбинации
        for(int i = 0; i < 3; i++){
            firstComb[i] = 1 + (int) (Math.random() * 6);
            secondComb[i] = 1 + (int) (Math.random() * 6);
        }

        int experiments = 10;

        for(int i = 0; i < experiments; i++){
            int curr1 = 1;
            int curr2 = 1;
            int score1 = 0;
            int score2 = 0;

            fillDiceResults();
            for(int j = 0; j < N; j++){

            }

        }

    }
}
