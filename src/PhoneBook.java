import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {
    String[][] phoneBook = {
            {"Иванов Иван Иванович", "+7 911 999 99 99"},
            {"Сергеева Мария Анатольевна", "+7 888 454 33 33"},
            {"Яшкин Валентин Петрович", "+7 788 567 44 44"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isDo = true;

        while (isDo) {
            System.out.println("Введите имя, которое хотите добавить в справочник");
            boolean isCorrectName = checkName(scanner.nextLine());
            while (!isCorrectName){
                System.out.println("Введие корректное имя в формате Фамилия Имя Отчество через пробел");
                isCorrectName = checkName(scanner.nextLine());
            }

            System.out.println("Нажмите y чтобы выйти, иначе продолжить");
            if (scanner.nextLine().equals("y")) isDo = false;
        }

        //Добавить считывание ввода пользователя в цикле

    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        String[] fullNameInArray = name.trim().split(" ");
        return fullNameInArray.length == 3;
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
