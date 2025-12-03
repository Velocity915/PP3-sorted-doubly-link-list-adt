package apps;

import adts.DLLSortedList;
public class DLLListPlay {
    
        public static void main(String[]args) {
    		DLLSortedList<String> list1 = new DLLSortedList<>();
                System.out.println(list1.isEmpty());
                list1.add("hi");
                System.out.println(list1);
                System.out.println(list1.size());
                System.out.println(list1.remove("hi"));
                list1.switchSearch();
                System.out.println(list1.remove("something"));
                
                list1.add("hello");
                list1.add("hey");
                list1.add("hi");
                System.out.println(list1);
                System.out.println(list1.isEmpty());
                System.out.println(list1.size());
                System.out.println(list1.get("hi"));
                System.out.println(list1.get(0));
                System.out.println(list1.contains("hello"));
                System.out.println(list1.contains("hi"));
                
                for (String s : list1) {
                    System.out.println(s);
                }
                for (String s : list1) {
                    System.out.println(s);
                }
                for (String s : list1) {
                    System.out.println(s);
                }
        }

}
