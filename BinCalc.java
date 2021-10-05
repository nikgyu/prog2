package algoritm;

import java.util.HashMap;
import java.util.Scanner;

public class BinCalc {

    public static void main(String[] args) {
        HashMap<String, Integer> vars = new HashMap();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] token = line.split(" ");

            if (token.length == 1) {
                System.out.println(vars.get(token[0]));
                continue;
            }

            int x = 0, y = 0;
            if (vars.containsKey(token[0])) {
                x = vars.get(token[0]);
            } else {
                try {
                    x = Integer.parseInt(token[0], 2);
                } catch (Exception e) {
                }
            }

            if (vars.containsKey(token[2])) {
                y = vars.get(token[2]);
            } else {
                try {
                    y = Integer.parseInt(token[2], 2);
                } catch (Exception e) {
                }
            }

            String result = "";

            switch (token[1]) {
                case "=":
                    vars.put(token[0], y);
                    break;
                case "|":
                    result = Integer.toBinaryString(x | y);
                    break;
                case "&":
                    result = Integer.toBinaryString(x & y);
                    break;
            }
            System.out.println(result);
        }
    }
}
