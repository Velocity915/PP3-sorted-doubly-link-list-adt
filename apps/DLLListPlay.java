package apps;

import adts.DLLSortedList;
public class DLLListPlay {
    
        public static void main(String[]args) {
    		DLLSortedList<String> list1 = new DLLSortedList<>();
                System.out.println(list1.isEmpty());
                list1.add("hi");
                System.out.println(list1);
                System.out.println(list1.size());
                list1.switchSearch("binary");
                System.out.println(list1.remove("hi"));
                System.out.println(list1.remove("something"));
                
                list1.add("hello");
                list1.add("hey");
                list1.add("hi");
                System.out.println(list1);
                System.out.println(list1.isEmpty());
                System.out.println(list1.size());
                list1.switchSearch("sequential");
                System.out.println(list1.get("hi"));
                System.out.println(list1.get("hey"));
                System.out.println(list1.get(0));
                System.out.println(list1.get(2));                
                System.out.println(list1.contains("hello"));
                System.out.println(list1.contains("hi"));
              
                System.out.println("\n");
                list1.setSwitcher("forward");
                for (String s : list1) {
                    System.out.println(s);
                }
                System.out.println("\n");
                list1.setSwitcher("reverse");
                for (String s : list1) {
                    System.out.println(s);
                }
                System.out.println("\n");
                list1.setSwitcher("random");
                for (String s : list1) {
                    System.out.println(s);
                }
        }

}
