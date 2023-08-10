package blam.tasks;

public class Task1 implements Solvable {
    //Размер массива
    private final int N;
    private final int[] array;
    //Для случайной генерации размера массива
    public Task1(){
        this.N = 5 + (int) (Math.random() * 96);
        this.array = new int[N];
    }
    //Для ручного ввода размера массива
    public Task1(int N){
        this.N = N;
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
        System.out.println(array[N-1] + "]");
    }
    private void swap(int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    //Реализация схемы Хоара
    private void quickSort(int left, int right, boolean ascendingOrder) {
        if (left >= right) return;

        //Вычисляем опорный элемент
        int mid = left + (right - left) / 2;
        int coreElem = array[mid];

        //Теперь делим на подмассивы и меняем местами
        int i = left, j = right;
        while (i <= j) {
            if(ascendingOrder) {
                while (array[i] < coreElem) i++;
                while (array[j] > coreElem) j--;
            } else{
                while (array[i] > coreElem) i++;
                while (array[j] < coreElem) j--;
            }
            if (i <= j) {
                swap(i++,j--);
            }
        }

        //Рекурсивный вызов для левой и правой части
        if (left < j) {
            quickSort(left, j, ascendingOrder);
        }
        if (right > i) {
            quickSort(i, right, ascendingOrder);
        }
    }
    @Override
    public void solve(){
        fillArray();
        printArray();

        int oddInd = 0; //индекс где заканчиваются нечетные
        int zeroInd = 0; //индекс где заканчиваются нули
        int evenInd = N-1; //индекс где начинаются четные

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

        //Шаг 2(сортировка частей): Применим быструю сортировку(схема Хоара) к частям разделенного массива
        //По возрастанию нечетные
        //По убыванию четные
        quickSort(0, oddInd-1, true);
        quickSort(evenInd + 1, N-1, false);
        printArray();
    }

}
