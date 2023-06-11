import java.io.FileWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Arrays;
import java.util.Random;

public class Task_02 {
    public static void main(String[] args) {
        Date date = new Date();
        try(FileWriter writer = new FileWriter("Log_02.txt", true)){
            Random random = new Random();
            writer.write("\n"+ date + "\n");
            writer.write("Creates a new random number generator.\n");
            int[] array = random.ints(10, 1, 10).toArray();
            writer.write("Creates a new random array.\n");
            System.out.println("\nМассив случайных чисел: " + Arrays.toString(array));
            writer.write(Arrays.toString(array) + "\n");
            Instant start = Instant.now();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        writer.write("Sorting: " + "i = " + i + ", j = " + j + ", " + Arrays.toString(array) + "\n");
                    }
                }
            }
            Instant finish = Instant.now();
            long elapsed = Duration.between(start, finish).toMillis();
            System.out.println("\nМассив отсортированный: " + Arrays.toString(array));
            writer.write("Sorted array: " + Arrays.toString(array) + "\n");
            writer.write("Sorting time (ms): " + elapsed + "\n");
            System.out.println("Получилось!");
            writer.write("It's done!\n");
        }
        catch (Exception e){
            System.out.println("Что то пошло не так");
        }
    }
}
