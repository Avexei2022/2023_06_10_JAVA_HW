import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Task_03 {
    public static void main(String[] args) {
        String initialString = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";
        String[] phraseString = new String[] {"Студент ", " получил ", " по предмету "};
        boolean try_write = string2file(initialString);
        if (try_write) {
            String goten_string = readString();
            String[] arrayStrings_01 = get_parse_01(goten_string);
            String[][] arrayStrings_02 = get_parse_02(arrayStrings_01);
            String[][][] arrayStrings_03 = get_parse_03(arrayStrings_02);
            printResult(arrayStrings_03, phraseString);
        } else {
            System.out.println("Ошибка записи строки в файл.");
        }

    }

    public static boolean string2file(String string) {
        try (FileWriter writer = new FileWriter("task_03.txt")) {
            writer.write(string);
            return true;
        } catch (Exception e) {
            System.out.println("Что то пошло не так");
            return false;
        }
    }

    public static String readString() {
        File file = new File("text.txt");
        String string = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            string = reader.readLine();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Что то пошло не так");
        }
        return string;
    }

    public static String[] get_parse_01(String string) {
        string = string.replaceAll("\"", "");
        String[] arrayStrings = string.split("},");
        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i] = arrayStrings[i].replace("{", "").replace("}", "");
        }
        return arrayStrings;
    }

    public static String[][] get_parse_02(String[] arrayStrings_01) {
        String[][] arrayStrings_02 = new String[arrayStrings_01.length][3];
        for (int i = 0; i < arrayStrings_01.length; i++) {
            arrayStrings_02[i] = arrayStrings_01[i].split(",");
        }
        return arrayStrings_02;
    }

    private static String[][][] get_parse_03(String[][] arrayStrings_02) {
        String[][][] arrayStrings_03 = new String[arrayStrings_02.length][3][2];
        for (int i = 0; i < arrayStrings_02.length; i++) {
            for (int j = 0; j < arrayStrings_02[i].length; j++) {
                arrayStrings_03[i][j] = arrayStrings_02[i][j].split(":");
            }
        }
        return arrayStrings_03;
    }

    public static void printResult(String[][][] arrayStrings_03, String[] phraseString) {
        StringBuilder string2print = new StringBuilder();
        for (int i = 0; i < arrayStrings_03.length; i++) {
            for (int j = 0; j < arrayStrings_03[i].length; j++) {
                string2print.append(phraseString[j]).append(arrayStrings_03[i][j][1]);
            }
            System.out.println(string2print);
            string2print.delete(0, string2print.length());
        }
    }        
}




