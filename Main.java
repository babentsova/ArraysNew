import java.util.HashSet;

public class Main {
    public static char[] findUniqueLetters(String[] words) {
        // Змінні для зберігання перших двох слів, що задовольняють умову
        String firstWord = null;
        String secondWord = null;

        // Перша ітерація по масиву рядків
        for (String word : words) {
            // Змінна для підрахунку кількості повторень кожної літери в слові
            int[] letterCount = new int[26];

            // Друга ітерація - підрахунок кількості повторень кожної літери
            for (char c : word.toCharArray()) {
                // Ігноруємо не-латинські літери
                if (Character.isLetter(c)) {
                    int index = Character.toLowerCase(c) - 'a';
                    letterCount[index]++;
                }
            }

            // Перевірка, чи кожна літера трапляється парну кількість разів
            boolean allEvenCount = true;
            for (int count : letterCount) {
                if (count % 2 != 0) {
                    allEvenCount = false;
                    break;
                }
            }

            // Якщо знайдено перше слово, що задовольняє умову
            if (allEvenCount && firstWord == null) {
                firstWord = word;
            }
            // Якщо знайдено друге слово, що задовольняє умову
            else if (allEvenCount && secondWord == null) {
                secondWord = word;
                break; // Вийти з циклу, якщо знайдено обидва слова
            }
        }

        // Створення набору унікальних символів зі слів
        HashSet<Character> uniqueLetters = new HashSet<>();
        if (firstWord != null) {
            for (char c : firstWord.toCharArray()) {
                uniqueLetters.add(c);
            }
        }
        if (secondWord != null) {
            for (char c : secondWord.toCharArray()) {
                uniqueLetters.add(c);
            }
        }

        // Перетворення набору унікальних символів на масив символів
        char[] result = new char[uniqueLetters.size()];
        int index = 0;
        for (char c : uniqueLetters) {
            result[index++] = c;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"mama", "dad", "granddad", "kids", "Family"};
        char[] uniqueLetters = findUniqueLetters(words);
        System.out.println(uniqueLetters);
    }
}
