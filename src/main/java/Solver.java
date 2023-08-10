import blam.tasks.Task1;
import blam.tasks.Task2;
import blam.tasks.Task3;

import java.util.Scanner;

public class Solver {
    public static void demonstrateTask1(){
        System.out.println("\nНАЧАЛО РЕШЕНИЯ ЗАДАЧИ 1");
        Task1 task1 = new Task1();
        task1.solve();
        System.out.println("\nКОНЕЦ РЕШЕНИЯ ЗАДАЧИ 1");
    }
    public static void demonstrateTask2(){
        Task2 task2 = new Task2();
        task2.solve();
    }
    public static void demonstrateTask3(){
        System.out.println("\nНАЧАЛО РЕШЕНИЯ ЗАДАЧИ 3\n");
        int N = 0;
        int[] firstCombination = new int[3];
        int[] secondCombination = new int[3];

        System.out.println("Введите число бросков кубика (натуральное четное число)");
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        if((N%2!=0) || (N<=0)){
            System.out.println("Неверный ввод, программа завершит работу, в следующий раз введите натуральное четное число");
            scanner.close();
            System.out.println("\nКОНЕЦ РЕШЕНИЯ ЗАДАЧИ 3");
            return;
        }

        System.out.println("Первый игрок, введите комбинацию из 3 целых чисел от 1 до 6 через пробел");
        for(int i = 0; i < 3; i++){
            int numberInCombination = scanner.nextInt();
            if((numberInCombination > 6) || (numberInCombination < 1)){
                System.out.println("Неверный ввод, программа завершит работу, в следующий раз введите 3 целых числа от 1 до 6");
                scanner.close();
                System.out.println("\nКОНЕЦ РЕШЕНИЯ ЗАДАЧИ 3");
                return;
            }
            firstCombination[i] = numberInCombination;
        }

        System.out.println("Второй игрок, введите комбинацию из 3 целых чисел от 1 до 6 через пробел");
        for(int i = 0; i < 3; i++){
            int numberInCombination = scanner.nextInt();

            if((numberInCombination > 6) || (numberInCombination < 1)){
                System.out.println("Неверный ввод, программа завершит работу, в следующий раз введите 3 целых числа от 1 до 6");
                scanner.close();
                System.out.println("\nКОНЕЦ РЕШЕНИЯ ЗАДАЧИ 3");
                return;
            }
            secondCombination[i] = numberInCombination;
        }
        System.out.println();

        Task3 task3 = new Task3(N, firstCombination, secondCombination);

        long time = System.currentTimeMillis();
        task3.solve();
        System.out.println(System.currentTimeMillis() - time);

        System.out.println("\nКОНЕЦ РЕШЕНИЯ ЗАДАЧИ 3");
    }
}
