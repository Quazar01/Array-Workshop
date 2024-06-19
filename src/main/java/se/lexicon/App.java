package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed

//        NameRepository.clear();
        System.out.println(NameRepository.getSize());   // 0;

        String[] names = NameRepository.findAll();
        System.out.println(Arrays.toString(names));
    }
}
