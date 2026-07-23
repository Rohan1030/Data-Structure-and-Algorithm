
      // gfg:- Remove all occurrences of a character in a string

class Solution {

    // Remove all occurrences of character 'c'
    public void removeCharacter(StringBuilder s, char c) {

        // Start recursion from the last index
        remove(s, c, s.length() - 1);
    }

    // Recursive helper function
    void remove(StringBuilder s, char c, int i) {

        // Base case: all characters processed
        if (i < 0) {
            return;
        }

        // Delete the character if it matches
        if (s.charAt(i) == c) {
            s.deleteCharAt(i);
        }

        // Recur for the previous character
        remove(s, c, i - 1);
    }
}