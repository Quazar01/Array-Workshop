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
        System.out.println(NameRepository.getSize());   // 0.

        String[] names = NameRepository.findAll();  // [Erik Svensson, Mehrdad Javan].
        System.out.println(Arrays.toString(names));

        String fullName = NameRepository.find("Erik Svensson");
        System.out.println(fullName);   // Erik Svensson.

        NameRepository.add("Sami Alabed");
        String[] namesAdd = NameRepository.findAll();
        System.out.println(Arrays.toString(namesAdd));  // [Erik Svensson, Mehrdad Javan, Sami Alabed].



    }
}
