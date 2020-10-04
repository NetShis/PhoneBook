import java.util.Scanner;

public class PhoneBook {
    static String[][] phoneBook = {
            {"Иванов Иван Иванович", "+7 911 999 99 99"},
            {"Сергеева Мария Анатольевна", "+7 888 454 33 33"},
            {"Яшкин Валентин Петрович", "+7 788 567 44 44"}
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name, phone;
        boolean isDo = true;

        while (isDo) {
            boolean IsNameInPhoneBook = false;
            System.out.println("Введите имя, которое хотите добавить в справочник");
            name = scanner.nextLine();
            boolean isCorrectName = checkName(name);
            while (!isCorrectName) {
                System.out.println("Введие корректное имя в формате: Фамилия Имя Отчество через пробел");
                name = scanner.nextLine();
                isCorrectName = checkName(name);
            }

            name = formatName(name);

            for (int i = 0; i < phoneBook.length; i++) {
                if (phoneBook[i][0].equals(name)) {
                    System.out.println(phoneBook[i][1]);
                    IsNameInPhoneBook = true;
                }
            }

            if (!IsNameInPhoneBook) {
                System.out.println("Введите номер телефона, для этого ФИО");
                phone = scanner.nextLine();
                boolean isCorrectPhone = checkPhoneNumber(phone);
                while (!isCorrectPhone) {
                    System.out.println("Введие корректый телефон в формате: +7 XXX XXX XX XX");
                    phone = scanner.nextLine();
                    isCorrectPhone = checkPhoneNumber(phone);
                }
                phone = formatPhoneNumber(phone);
                add(phoneBook, name, phone);
            }

            list(phoneBook);
            System.out.println("Нажмите y чтобы выйти, иначе продолжить");
            if (scanner.nextLine().equals("y")) isDo = false;
        }

        //Добавить считывание ввода пользователя в цикле

    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public static boolean checkName(String name) {
        String[] fullNameInArray = name.trim().split(" ");
        return fullNameInArray.length == 3;
    }

    public static String formatName(String name) {
        name = name.toLowerCase();
        String[] nameInArray = name.split(" ");
        nameInArray[0] = nameInArray[0].substring(0, 1).toUpperCase() + nameInArray[0].substring(1, nameInArray[0].length());
        nameInArray[1] = nameInArray[1].substring(0, 1).toUpperCase() + nameInArray[1].substring(1, nameInArray[1].length());
        nameInArray[2] = nameInArray[2].substring(0, 1).toUpperCase() + nameInArray[2].substring(1, nameInArray[2].length());
        return nameInArray[0] + " " + nameInArray[1] + " " + nameInArray[2];
    }

    public static String formatPhoneNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        return "+7" + " " + clean.substring(1, 4) + " " + clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
    }

    public static void add(String[][] book, String name, String number) {
        String[][] tempPhoneBook = new String[book.length + 1][2];
        for (int i = 0; i < tempPhoneBook.length - 1; i++) {
            tempPhoneBook[i][0] = book[i][0];
            tempPhoneBook[i][1] = book[i][1];
        }
        tempPhoneBook[book.length][0] = name;
        tempPhoneBook[book.length][1] = number;
        phoneBook = tempPhoneBook;
    }

    public static void list(String[][] book) {
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i][0] + ": " + book[i][1]);
        }
    }
}
