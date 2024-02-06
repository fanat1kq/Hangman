import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
   static int number=1;
     static Set<String> usedLetters= new HashSet<String>();
    public static void main(String[] args) throws IOException {
            while (true) {
                System.out.println("Начать игру?(да/нет):");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("да")) loopGame();
                else if (input.equals("нет")){
                    scanner.close();

                    System.exit(0);
                }
                else System.out.println("попробуйте еще раз");
            }
        }
        public static void loopGame() throws IOException {
        System.out.println("Начало нового раунда:");
        String word =createWord().toLowerCase();
        String str = "*".repeat(word.length());
        System.out.println(word);
        System.out.println(str);
        game(word, str);
    }

    public static String createWord() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while(line != null) {
                String[] wordsLine = line.split(" ");
                for(String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }
            Random rand = new Random(System.currentTimeMillis());
            String randomWord = words.get(rand.nextInt(words.size()));
            return randomWord;
    }

    public static void game(String word, String newWord) {
        do{
            System.out.println("введите букву");
            Scanner sc = new Scanner(System.in);
            String letter = sc.nextLine().toLowerCase();
            if (checkLetter(letter,word,newWord).equals(newWord) ) printHangMan();

            if (!usedLetters.contains(letter)) {usedLetters.add(letter);}
            else System.out.println("Вы уже вводили " + letter + ". Попробуйте другую букву");
            if (!checkRussianLetter(letter.charAt(0))) System.out.println("только русские буквы!");
            newWord =checkLetter(letter,word,newWord);
            if (checkLetter(letter,word,newWord).equals(newWord) ) printHangMan();
            System.out.println(checkLetter(letter,word,newWord));
                if (!newWord.contains("*")) {System.out.println("Победа");

                };

        }
        while (true);

            }


    public static void printHangMan(){
        number++;
        switch (number) {

            case 2:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                System.out.println("Осталось 6 попыток");
                break;
            case 4:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                System.out.println("Осталось 5 попыток");
                break;
            case 6:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |    |");
                System.out.println("  |    ");
                System.out.println("__|_______");
                System.out.println("Осталось 4 попытки");
                break;
            case 8:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /| ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                System.out.println("Осталось 3 попытки");
                break;
            case 10:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |    ");
                System.out.println("__|_______");
                System.out.println("Осталось 2 попытки");
                break;
            case 12:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |   / ");
                System.out.println("__|_______");
                System.out.println("Осталось 1 попытка");
                break;
            case 14:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |   / \\");
                System.out.println("__|_______");
                System.out.println("Game is over");
                break;


            default:
                break;
        }
    }

    public static String checkLetter(String character, String word, String str)  {
        char[] charStr=str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (word.charAt(i) == character.charAt(0)) {
                charStr[i] = character.charAt(0);
            }
        }
        return String.valueOf(charStr);
    }

    public static boolean checkRussianLetter(char userInput) {
        String regex = "[а-яА-ЯёЁ]";
        return Pattern.matches(regex, String.valueOf(userInput));
    }
    }
