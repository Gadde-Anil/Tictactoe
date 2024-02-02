import java.util.*;
import java.io.*;

class tictactoe {
    static HashSet<Integer> ur_set = new HashSet<Integer>();
    static HashSet<Integer> comp_set = new HashSet<Integer>();

    public static void main(String args[]) {
        char[][] g_board = {
                { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' }
        };
        print_board(g_board);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter values from 1-9:");
            int user_pos = sc.nextInt();
            while (ur_set.contains(user_pos) || comp_set.contains(user_pos)) {
                System.out.println();
                System.out.print("Retry , Enter values from 1-9:");
                user_pos = sc.nextInt();
            }
            p_holder(g_board, user_pos, "YOU");
            String res = check_winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }

            int cpu_pos = gen_random();
            while (ur_set.contains(cpu_pos) || comp_set.contains(cpu_pos)) {
                System.out.println();
                cpu_pos = gen_random();
            }
            p_holder(g_board, cpu_pos, "Comp");
            res = check_winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }
        }
    }

    static String check_winner() {
        HashSet<Integer> r1 = new HashSet<Integer>();
        r1.add(1);
        r1.add(2);
        r1.add(3);
        HashSet<Integer> r2 = new HashSet<Integer>();
        r2.add(4);
        r2.add(5);
        r2.add(6);
        HashSet<Integer> r3 = new HashSet<Integer>();
        r3.add(7);
        r3.add(8);
        r3.add(9);
        HashSet<Integer> c1 = new HashSet<Integer>();
        c1.add(1);
        c1.add(4);
        c1.add(7);
        HashSet<Integer> c2 = new HashSet<Integer>();
        c2.add(2);
        c2.add(5);
        c2.add(8);
        HashSet<Integer> c3 = new HashSet<Integer>();
        c3.add(3);
        c3.add(6);
        c3.add(9);
        HashSet<Integer> d1 = new HashSet<Integer>();
        d1.add(1);
        d1.add(5);
        d1.add(9);
        HashSet<Integer> d2 = new HashSet<Integer>();
        d2.add(3);
        d2.add(5);
        d2.add(7);
        HashSet<HashSet> check = new HashSet<HashSet>();
        check.add(r1);
        check.add(r2);
        check.add(r3);
        check.add(c1);
        check.add(c2);
        check.add(c3);
        check.add(d1);
        check.add(d2);
        for (HashSet c : check) {
            if (ur_set.containsAll(c)) {
                return "YOU WON";
            } else if (comp_set.containsAll(c)) {
                return "YOU LOST";
            }
        }
        if (ur_set.size() + comp_set.size() == 9) {
            return "DRAW";
        }
        return "";
    }

    static int gen_random() {
        int max = 9;
        int min = 1;
        int range = max - min + 1;
        int res = (int) (Math.random() * range) + min;
        return res;
    }

    static void print_board(char[][] g_board) {
        for (int r = 0; r < g_board.length; r++) {
            for (int c = 0; c < g_board[0].length; c++) {
                System.out.print(g_board[r][c]);
            }
            System.out.println();
        }
    }

    static void p_holder(char[][] g_board, int pos, String user) {
        char syb = 'X';
        if (user.equals("YOU")) {
            syb = 'X';
            ur_set.add(pos);
        } else if (user.equals("Comp")) {
            syb = 'O';
            comp_set.add(pos);
        }
        switch (pos) {
            case 1:
                g_board[0][0] = syb;
                break;
            case 2:
                g_board[0][2] = syb;
                break;
            case 3:
                g_board[0][4] = syb;
                break;
            case 4:
                g_board[2][0] = syb;
                break;
            case 5:
                g_board[2][2] = syb;
                break;
            case 6:
                g_board[2][4] = syb;
                break;
            case 7:
                g_board[4][0] = syb;
                break;
            case 8:
                g_board[4][2] = syb;
                break;
            case 9:
                g_board[4][4] = syb;
                break;
            default:
                System.out.println("Invail Input");
        }
        print_board(g_board);
    }
}