package se.lexicon;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        //todo: PART 1: implement setNames method

        // Assign the names array to a new array with the same length as the provided array.
        NameRepository.names = new String[names.length];

        // Copy all elements from the provided array to the names array.
        for(int i = 0; i < names.length; i++) {
            NameRepository.names[i] = names[i];
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method

        // Assign the names array to a new empty array.
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method

        // Create a new array with the same length as the names array.
        String[] allNames = new String[NameRepository.names.length];

        // Copy all elements from the names array to the new array.
        for(int i = 0; i < NameRepository.names.length; i++) {
            allNames[i] = NameRepository.names[i];
        }

        return allNames;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: PART 2: implement find method

        // Loop through all elements in the names array.
        for(String name : NameRepository.names) {
            // Check if the current name is equal to the provided fullName case-insensitively.
            if(name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: PART 2: implement add method

        // Check if the fullName already exists in the names array.
        if(find(fullName) == null) {
            // Create a new array with a length of the current names array + 1.
            String[] newNames = new String[NameRepository.names.length + 1];

            // Copy all elements from the names array to the new array.
            for(int i = 0; i < NameRepository.names.length; i++) {
                newNames[i] = NameRepository.names[i];
            }

            // Add the new fullName to the last index of the new array.
            newNames[newNames.length - 1] = fullName;

            // Assign the names array to the new array.
            NameRepository.names = newNames;

            return true;
        }

        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: PART 3: findByFirstName method

        // Declare an empty string array to return it in case no names match the given firstName.
        String[] emptyArray = new String[0];
        // Counting how many names that match the given firstName.
        int count = 0;

        for (String name : NameRepository.names) {
            // Split the name into first and last names.
            String[] nameParts = name.split(" ");
            // Check if the first name matches the provided firstName.
            if (nameParts[0].equalsIgnoreCase(firstName)) {
                count++;
            }
        }
        
        // Create a new array with the same length as the count.
        String[] firstNames = new String[count];
        
        // Index to keep track of the current index of the firstNames array.
        int index = 0;
        
        // Fill the firstNames array with all names that match the given firstName.
        for (String name : NameRepository.names) {
            // Split the name into first and last names.
            String[] nameParts = name.split(" ");
            // Check if the first name matches the provided firstName.
            if (nameParts[0].equalsIgnoreCase(firstName)) {
                firstNames[index] = name;
                index++;
            }
        }

        if (firstNames.length > 0) {
            return firstNames;
        }
        else {
            return emptyArray;
        }
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: PART 3: implement findByLastName method

        // Same logic as findByFirstName method, but with the last name.
        // Declare an empty string array to return it in case no names match the given firstName.
        String[] emptyArray = new String[0];
        // Count how many names that match the given lastName.
        int count = 0;
        for (String name : NameRepository.names) {
            String[] nameParts = name.split(" ");
            if (nameParts[1].equalsIgnoreCase(lastName)) {
                count++;
            }
        }

        // Create a new array with the same length as the count.
        String[] lastNames = new String[count];

        // Index to keep track of the current index of the lastNames array.
        int index = 0;

        // Fill the lastNames array with all names that match the given lastName.
        for (String name : NameRepository.names) {
            String[] nameParts = name.split(" ");
            if (nameParts[1].equalsIgnoreCase(lastName)) {
                lastNames[index] = name;
                index++;
            }
        }

        if (lastNames.length > 0) {
            return lastNames;
        }
        else {
            return emptyArray;
        }
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: PART 3: implement update method

        // Check if the updated name already exists in the names array.
        if(find(updatedName) == null) {
            // Loop through all elements in the names array.
            for(int i = 0; i < NameRepository.names.length; i++) {
                // Check if the current name is equal to the original name case-insensitively.
                if(NameRepository.names[i].equalsIgnoreCase(original)) {
                    // Update the name to the updated name.
                    NameRepository.names[i] = updatedName;
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        //todo: PART 4: implement remove method

        // Loop through all elements in the names array.
        for(int i = 0; i < NameRepository.names.length; i++) {
            // Check if the current name is equal to the provided fullName case-insensitively.
            if(NameRepository.names[i].equalsIgnoreCase(fullName)) {
                // Create a new array with a length of the current names array - 1.
                String[] newNames = new String[NameRepository.names.length - 1];

                // Index to keep track of the current index of the newNames array.
                int index = 0;

                // Copy all elements from the names array to the new array, except the removed name.
                for(int j = 0; j < NameRepository.names.length; j++) {
                    if(j != i) {
                        newNames[index] = NameRepository.names[j];
                        index++;
                    }
                }
                // Assign the names array to the new array.
                NameRepository.names = newNames;

                return true;
            }
        }
        return false;
    }


}