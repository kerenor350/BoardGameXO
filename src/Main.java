import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[] boardGame = new char[9];
        int turn = 0;
        for (int i = 1; i <= 10; i++) {
            if(i==10){
                System.out.println("Draw!");
                break;
            }
            int position;
            Scanner scanner = new Scanner(System.in);
            if (turn % 2 == 0) {
                System.out.println("player one : x");
                position = scanner.nextInt();
                position = getPositionFromUser(position, boardGame);
                placeSymbolOnBoard(boardGame, position, 'x');
                if(checkWinner(boardGame)=='x')
                    break;
            }
            if (turn % 2 != 0) {
                System.out.println("player two : o");
                position = scanner.nextInt();
                position = getPositionFromUser(position, boardGame);
                placeSymbolOnBoard(boardGame, position, 'o');
                if (checkWinner(boardGame)=='o'){
                    break;
                }
            }
            turn++;
        }
    }

    public static void printBoard(char[] boardGame) {
        for (int y = 0; y <= 2; y++) {
            System.out.print(boardGame[y] + "\t");
        }
        System.out.println();

        for (int y = 3; y <= 5; y++) {
            System.out.print(boardGame[y] + "\t");
        }
        System.out.println();

        for (int y = 6; y <= 8; y++) {
            System.out.print(boardGame[y] + "\t");
        }
        System.out.println();

    }

    public static boolean isAvailable(char[] boardGame, int index) {
        char x = 'x';
        char o = 'o';
        boolean checker = true;
        if (boardGame[index] == x || boardGame[index] == o) {
            checker = false;
            System.out.println("This position is taken");
        }
        return checker;
    }

    public static int getPositionFromUser(int choosePosition, char[] boardGame) {
        Scanner scanner = new Scanner(System.in);
        while (choosePosition < 0 || choosePosition > 8) {
            System.out.println("wrong position ,choose a different one :");
            choosePosition = scanner.nextInt();
        }
        boolean answer = isAvailable(boardGame, choosePosition);
        while (!answer) {
            choosePosition = scanner.nextInt();
            answer = isAvailable(boardGame, choosePosition);
        }
        return choosePosition;
    }

    public static char checkWinner(char[] boardGame) {
        char w = 0;
        char x = 'x';
        char o = 'o';

        if (boardGame[0] == x && boardGame[1] == x && boardGame[2] == x) {
            w = x;
        } else if (boardGame[3] == x && boardGame[4] == x && boardGame[5] == x) {
            w = x;
        } else if (boardGame[6] == x && boardGame[7] == x && boardGame[8] == x) {
            w = x;
        } else if (boardGame[0] == x && boardGame[3] == x && boardGame[6] == x) {
            w = x;
        } else if (boardGame[1] == x && boardGame[4] == x && boardGame[7] == x) {
            w = x;
        } else if (boardGame[2] == x && boardGame[5] == x && boardGame[8] == x) {
            w = x;
        } else if (boardGame[0] == x && boardGame[4] == x && boardGame[8] == x) {
            w = x;
        } else if (boardGame[2] == x && boardGame[4] == x && boardGame[6] == x) {
            w = x;
        } else if (boardGame[0] == o && boardGame[1] == o && boardGame[2] == o) {
            w = o;
        } else if (boardGame[3] == o && boardGame[4] == o && boardGame[5] == o) {
            w = o;
        } else if (boardGame[6] == o && boardGame[7] == o && boardGame[8] == o) {
            w = o;
        } else if (boardGame[0] == o && boardGame[3] == o && boardGame[6] == o) {
            w = o;
        } else if (boardGame[1] == o && boardGame[4] == o && boardGame[7] == o) {
            w = o;
        } else if (boardGame[2] == o && boardGame[5] == o && boardGame[8] == o) {
            w = x;
        } else if (boardGame[0] == o && boardGame[4] == o && boardGame[8] == o) {
            w = o;
        } else if (boardGame[2] == o && boardGame[4] == o && boardGame[6] == o) {
            w = o;
        }

        return w;
    }

    public static void placeSymbolOnBoard(char[] boardGame, int position, char symbol) {
        boardGame[position] = symbol;
        printBoard(boardGame);
        int check = checkWinner(boardGame);
        if (check == 'x') {
            System.out.println("player one win");
        }
        if (check == 'o') {
            System.out.println("player two win");
        }
        if (check == '-') {
            System.out.println("draw");
        }

    }
}


