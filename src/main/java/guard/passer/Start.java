package guard.passer;

import java.util.Map;
import java.util.TreeMap;

public class Start {

    static TreeMap<Long, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        Stdin stdin = new Stdin("A", "1", '0', 55, 'B', 100L, 2, 2);
        sendOrder(stdin);
        Stdin stdin1 = new Stdin("A", "2", '0', 55, 'B', 101L, 3, 3);
        sendOrder(stdin1);
        Stdin stdin2 = new Stdin("B", "1", '0', 55, 'B', 99L, 10, 10);
        sendOrder(stdin2);
        Stdin stdin3 = new Stdin("A", "2", '1', 55, 'B', 101L, 3, 0);
        sendOrder(stdin3);
        Stdin stdin4 = new Stdin("B", "2", '0', 55, 'B', 100L, 3, 3);
        sendOrder(stdin4);
        Stdin stdin5 = new Stdin("A", "1", '2', 55, 'B', 100L, 1, 1);
        sendOrder(stdin5);
    }

    private static void sendOrder(Stdin stdin) {
        System.out.printf("stdin: %s;%s;%s;%s;%s;%s;%s;%s \n", stdin.getUserId(), stdin.getClorderId(),
                stdin.getAction(), stdin.getInstrumentId(), stdin.getSide(), stdin.getPrice(), stdin.getAmount(),
                stdin.getAmountRest());
        boolean print = true;
        if (stdin.getAction().equals('0')) {
            if (map.containsKey(stdin.getPrice())) {
                Integer value = map.get(stdin.getPrice());
                map.put(stdin.getPrice(), value + stdin.getAmount());
            } else {
                map.put(stdin.getPrice(), stdin.getAmount());
                if (!stdin.getPrice().equals(map.lastKey())) {
                    print = false;
                }
            }
        } else {
            Integer count = map.get(stdin.getPrice());
            if (count - stdin.getAmount() > 0) {
                map.put(stdin.getPrice(), count - stdin.getAmount());
            } else {
                map.remove(stdin.getPrice());
            }
        }

//        printMap(map);// debug
        Long key = map.lastKey();
        if (print) {
            System.out.printf("stdout: %s;%s;%s;%s \n", stdin.getInstrumentId(), stdin.getSide(), key, map.get(key));
        } else {
            System.out.println("-");
        }
        System.out.println();
    }


    private static void printMap(TreeMap<Long, Integer> map) {
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            Long key = entry.getKey();
            Integer value = entry.getValue();
            if (key.equals(map.lastKey())) {
                System.out.print("* ");
            }
            System.out.println(key + " : " + value);
        }
        System.out.println("------------------");
    }
}