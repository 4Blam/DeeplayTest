package blam.tasks;

import java.util.HashMap;

public class Task2 implements Solvable{
    //Размер массива - случайное число от 5 до 100
    private final int N;
    private final int[] array;
    public Task2(){
        this.N = 5 + (int) (Math.random() * 96);
        this.array = new int[N];
        fillArray();
    }
    public Task2(int N){
        this.N = N;
        this.array = new int[N];
        fillArray();
    }
    public Task2(int[] array){
        this.N = array.length;
        this.array = array;
    }
    //Заполняем масссив случайными целыми числами в диапазоне [0; sqrt(N) (округленное вниз)]
    private void fillArray(){
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * (Math.sqrt(N)));
        }
    }
    private void printArray() {
        System.out.println();
        System.out.print("[");
        for(int i = 0; i < N-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[N-1] + "]\n");
    }
    @Override
    public void solve() {
        printArray();
        //Для общности можно было оставить размер пустым (на случай если числа помещенные в массив неограничены),
        // однако в конкретно этой задаче(моей интерпретации),
        // можно инициализировать HashMap размером sqrt(N) т.к. диапазон чисел известен

        HashMap<Integer, Integer> CountMap = new HashMap<>((int) Math.sqrt(N));
        for(int i = 0; i < N; i++){
            //Операция, которая выполняет как раз то, что нам надо - либо создает элемент и инициализрует его 1,
            //либо добавляет к счетчику 1
            CountMap.merge(array[i], 1, Integer::sum);
        }

        int maxcounter = 0;
        //System.out.println(CountMap);
        //Находим макс. количество входов
        for (int number: CountMap.keySet()) {
            if(maxcounter < CountMap.get(number)){
                maxcounter = CountMap.get(number);
            }
        }

        //Выводим значение с макс количеством
        for (int number: CountMap.keySet()) {
            if(maxcounter == CountMap.get(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
