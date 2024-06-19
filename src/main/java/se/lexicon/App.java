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

        // Find all names.
        String[] names = NameRepository.findAll();  // [Erik Svensson, Mehrdad Javan].
        System.out.println(Arrays.toString(names));

        // Find a name.
        String fullName = NameRepository.find("Erik Svensson");
        System.out.println(fullName);   // Erik Svensson.

        // Add a new name.
        NameRepository.add("Sami Alabed");
        String[] namesAdd = NameRepository.findAll();
        System.out.println(Arrays.toString(namesAdd));  // [Erik Svensson, Mehrdad Javan, Sami Alabed].

        // Find by first name.
        String[] firstNames = NameRepository.findByFirstName("Erik");
        System.out.println(Arrays.toString(firstNames));  // [Erik Svensson].

        // Find by last name.
        String[] lastNames = NameRepository.findByLastName("Svensson");
        System.out.println(Arrays.toString(lastNames));  // [Erik Svensson].

        // Update a name.
        boolean updated = NameRepository.update("Erik Svensson", "Erik Svensson Updated");
        System.out.println(updated);  // true.
        boolean updated2 = NameRepository.update("Eriks", "not found.");
        System.out.println(updated2);  // false.

        // Remove a name.
        boolean removed = NameRepository.remove("Erik Svensson Updated");
        System.out.println(removed);  // true.

        // Confirm the name is removed.
        String[] names2 = NameRepository.findAll();  // [Mehrdad Javan, Sami Alabed].
        System.out.println(Arrays.toString(names2));

    }
}
