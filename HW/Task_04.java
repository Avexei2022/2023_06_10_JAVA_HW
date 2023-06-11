import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Task_04 {


    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task_04.class.getName());
        FileHandler fh = new FileHandler("log_04.txt");
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        System.out.println("\nЗадача 4.\n");
        logger.log(Level.WARNING, "Start: Task_04","cp866");
        float num_A = getNum("Введите первое число А: ");
        logger.log(Level.INFO, "Input number A -> " + num_A,"cp866");
        String sign_in = getOper("Введите знак (+ - * /): ");
        logger.log(Level.INFO, "Input sign -> " + sign_in,"cp866");
        float num_B = getNum("Введите второе число B: ");
        logger.log(Level.INFO, "Input number B -> " + num_B,"cp866");        
        float result = getResult(num_A, num_B, sign_in);
        logger.log(Level.INFO, "Get result -> " + result,"cp866");    
        System.out.printf("Результат: %f %s %f = %f", num_A, sign_in, num_B, result);
        System.out.println("\nКонец задачи 3.\n");
        logger.log(Level.WARNING, "End: Task_04","cp866");
    }

    public static float getNum(String string) {
        System.out.printf(string);
        float number = 0;
        try {
            number = iScanner.nextFloat();
            // iScanner.close();
        } catch (Exception e) {
            System.out.println("Вы не захотели вводить число, будем считать что вы ввели цифру 0.");
            number = 0;
        }
        return number;
    }

    private static String getOper(String string) {
        String[] signes = new String[] { "+", "-", "*", "/" };
        System.out.printf(string);
        String sign_input = iScanner.next();
        // iScanner.close();
        boolean flag = true;
        for (int i = 0; i < signes.length; i++) {
            if (signes[i].equals(sign_input)) {
                flag = false;
            }
        }
        if (flag){
            sign_input = getOper(string);
        }
        return sign_input;
    }

    private static float getResult(Float num_A, Float num_B, String sign_in) {
        float result = 0;
        switch (sign_in) {
            case "+":
                result = num_A + num_B;
                break;
            case "-":
                result = num_A - num_B;
                break;
            case "*":
                result = num_A * num_B;
                break;
            case "/":
                if (num_B == 0) {
                    System.out.println("Делить на 0 нельзя!");
                    result = 999999;
                } else {
                    result = num_A / num_B;
                }
                break;
        }
        return result;
    }


}


