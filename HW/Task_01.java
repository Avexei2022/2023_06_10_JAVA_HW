/**
 * Task_01
 */
public class Task_01 {

    public static void main(String[] args) {
        String input_str = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println("\nВведенная строка: " + input_str);
        String[] input_array = get_item(input_str);
        StringBuilder output_str = get_string(input_array);
        System.out.println("\nСтрока SQL-запроса: " + output_str);
        System.out.println();
    }

    public static String[] get_item(String input_str) {
        input_str = input_str.replaceAll(" ", "");
        input_str = input_str.replaceAll("\"", "");
        input_str = input_str.replace("}", "").replace("{", "");
        ;
        String[] input_array = input_str.split(",");
        return input_array;
    }
    
    public static StringBuilder get_string(String [] input_array) {
        StringBuilder output_str = new StringBuilder();
        String[] el_tmp = new String[2];
        String new_str = "";
        for (String el : input_array) {
            el_tmp = el.split(":");
            if (!el_tmp[1].equals("null")) {
                new_str = " AND " + el_tmp[0] + " = " + el_tmp[1];
                output_str.append(new_str);
            }
        }
        if (output_str.length() > 0) {
            output_str.delete(0, 4);
            output_str.insert(0," WHERE");
        } 
        return output_str.insert(0, "select * from student");
    }
}