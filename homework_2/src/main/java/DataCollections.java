import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * DataCollections - класс проводит операции с числами и их делителями.
 *
 * @version 1.00 09 Dec 2020
 * @author Агафонова Евгения
 */
public class DataCollections {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), true); // Map всегда содержит только уникальные ключи
        }

        System.out.println(list.size() == map.size());

        ArrayList<Integer> listAliquot2 = new ArrayList();
        ArrayList<Integer> listAliquot3 = new ArrayList();
        ArrayList<Integer> listAliquot5 = new ArrayList();
        ArrayList<Integer> listAliquot7 = new ArrayList();

        for (Integer number: list) {
            if(number % 2 == 0){
                listAliquot2.add(number);
            } else if(number % 3 == 0) {
                listAliquot3.add(number);
            } else if(number % 5 == 0) {
                listAliquot5.add(number);
            } else if(number % 7 == 0) {
                listAliquot7.add(number);
            }
        }
    }
}
