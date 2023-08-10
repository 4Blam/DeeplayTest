package blam.tasks;

import java.util.Arrays;

public class Task1 implements Solvable {
    //Размер массива - случайное число от 5 до 100
    private final int N;
    private int[] array;
    public Task1(){
        //this.N = 5 + (int) (Math.random() * 96);
        this.N = 10;
        this.array = new int[N];
    }
    //Заполняем масссив случайными целыми числами в диапазоне [-N/2;N/2]
    //При нечетном N числа будут в диапазоне [-(N-1)/2; (N-1)/2]
    private void fillArray(){
        if(N%2 == 0) {
            for (int i = 0; i < N; i++) {
                array[i] = (int) (Math.random() * (N + 1)) - (N / 2);
            }
        } else {
            for (int i = 0; i < N; i++) {
                array[i] = (int) (Math.random() * N) - (N / 2);
            }
        }

    }
    private void printArray() {
        System.out.println();
        System.out.print("[");
        for(int i = 0; i < N-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[N-1] + "]");
    }
    private void swap (int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    public void solve(){
        fillArray();
        printArray();

        int oddInd = 0; //левая граница
        int zeroInd = 0; //центр
        int evenInd = N-1; //правая граница

        //Шаг 1(разделение массива): Подойдем к задаче как к решению проблемы флага Нидерландов
        while (zeroInd <= evenInd){
            if((array[zeroInd] % 2 == 1) || (array[zeroInd] % 2 == -1)){
                swap(oddInd++, zeroInd++);
                continue;
            }
            if(array[zeroInd] == 0){
                zeroInd++;
                continue;
            }

            swap(zeroInd, evenInd--);
        }

        //удалить
        printArray();
        System.out.println("\nНечетные: [0; " + (oddInd-1) + "], " +
                "Нули: [" + oddInd + ";" + (zeroInd - 1) + "], " +
                "Четные: [" + (N + 1 - evenInd) + ";" + (N-1) + "]");
    }
}
