   //383. Ransom Note

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count frequency of characters in ransomNote
        for (char c : ransomNote.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // Count frequency of characters in magazine
        for (char c : magazine.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Check if magazine has enough characters
        for (char c : map1.keySet()) {

            if (map2.getOrDefault(c, 0) < map1.get(c)) {
                return false;
            }
        }

        return true;
    }
}