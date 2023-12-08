import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
   static int number=1;
    public static void main(String[] args) throws IOException {
            while (true) {
                loopGame();
            }
        }
        public static void loopGame() throws IOException {

        System.out.println("Начало нового раунда:");
        String word =createWord().toLowerCase();

        String str = "*".repeat(word.length());
        System.out.println(word);
        System.out.println(str);

        game(word, str);

//        Scanner sc = new Scanner(System.in);
//        System.out.println("New or Exit");
//        String phrase1 = sc.nextLine();
//        System.out.println(phrase1);
//        if (phrase1=="N") startGameLoop();
//                else if (phrase1=="E") sc.close();
//                    else System.out.println("попробуйте еще раз");

    }

    public static String createWord() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("src/dictionary.txt"));
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

    public static void game(String word, String new_word) throws IOException {
        do{System.out.println("введите букву");
         Scanner sc = new Scanner(System.in);
            String charac = sc.nextLine().toLowerCase();// если ввел заглавную
            if (new_word.contains(charac)) System.out.println("Вы уже вводили "+ charac+ ". Попробуйте другую букву");

            if (checkCharacter(charac,word,new_word).equals(new_word)) HangMan();///перепроверить
            new_word =checkCharacter(charac,word,new_word);

            System.out.println(checkCharacter(charac,word,new_word));

            if (!new_word.contains("*")) System.out.println("Победа");

        }//отгаданное слово
        while (true);

            }


    public static void HangMan(){


        number++;
        switch (number) {


            case 2:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 4:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 6:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |    |");
                System.out.println("  |    ");
                System.out.println("__|_______");
                break;
            case 8:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /| ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 10:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |    ");
                System.out.println("__|_______");
                break;
            case 12:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |   / ");
                System.out.println("__|_______");
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

    public static String checkCharacter(String character, String word, String str) throws IOException {//отгадывание буквы
        char[] charStr=str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (word.charAt(i) == character.charAt(0)) {//замена отгаданной буквы
                charStr[i] = character.charAt(0);
            }
        }

//        if (String.valueOf(charStr).equals(str)) HangMan();
//        else System.out.println("Угадали");

        return String.valueOf(charStr);
    }
    }