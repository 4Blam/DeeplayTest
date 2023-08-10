package blam.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 implements Solvable{
    //Комбинация первого игрока
    private final int[] firstComb;
    //Комбинация второго игрока
    private final int[] secondComb;
    //Количество бросков
    private final int N;
    //Результат бросков(меняется в каждом эксперименте)
    private int[] diceResults;
    //Для случайной генерации
    public Task3(){
        this.firstComb = new int[3];
        this.secondComb = new int[3];
        this.N = 1000;
        this.diceResults = new int[N];
        fillCombinations();
    }
    //Для ручного ввода игроков (основной конструктор)
    public Task3(int N, int[] firstComb, int[] secondComb){
        this.firstComb = firstComb;
        this.secondComb = secondComb;
        this.N = N;
        this.diceResults = new int[N];
    }
    private void fillDiceResults(){
        for(int i = 0; i < N; i++){
            diceResults[i] = 1 + (int) (Math.random() * 6);
        }
    }
    private void fillCombinations(){
        //Зададим комбинации (случайно) и выведем их на экран
        for (int i = 0; i < 3; i++) {
            firstComb[i] = 1 + (int) (Math.random() * 6);
            System.out.print(firstComb[i] + " ");
            secondComb[i] = 1 + (int) (Math.random() * 6);
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.print(secondComb[i] + " ");
        }
        System.out.println();

    }
    @Override
    public void solve() {
        //Проведем 100000 экспериментов
        int experiments = 100000;

        int firstWin = 0, draw = 0, secondWin = 0;

        for(int i = 0; i < experiments; i++){

            int curr1 = 1, curr2 = 1, score1 = 0, score2 = 0;

            fillDiceResults();

            //В силу того что размер паттерна известен и очень мал - можем использовать нативный алгоритм Брута-Форса
            while((curr1 <= N - 2) && (curr2 <= N - 2)){

                if(curr1 <= N-2) {
                    if ((firstComb[0] == diceResults[curr1 - 1]) &&
                            (firstComb[1] == diceResults[curr1]) &&
                            (firstComb[2] == diceResults[curr1 + 1])) {
                        score1++;
                        //Нельзя пересекаться
                        curr1 += 3;
                    } else {
                        curr1++;
                    }
                }
                if(curr2 <= N-2) {
                    if ((secondComb[0] == diceResults[curr2 - 1]) &&
                            (secondComb[1] == diceResults[curr2]) &&
                            (secondComb[2] == diceResults[curr2 + 1])) {
                        score2++;
                        //Нельзя пересекаться
                        curr2 += 3;
                    } else {
                        curr2++;
                    }
                }

            }

            if(score2 > score1){
                secondWin++;
            }
            if(score1 > score2){
                firstWin++;
            }
            if(score1 == score2){
                draw++;
            }
        }

        System.out.println("Вероятность ничьи = " + (double) draw/(double) experiments);
        System.out.println("Вероятность победы первого игрока = " + (double) firstWin/(double) experiments);
        System.out.println("Вероятность победы второго игрока = " + (double) secondWin/ (double) experiments);
    }
}
