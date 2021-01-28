package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        HashMap<Character, Integer> letter_code  = new HashMap<>();
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o' ,'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '\''};
        int[] arr2 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 54, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101, 103};
        for (int i = 0; i < arr.length; i++) {
            letter_code.put(arr[i], arr2[i]);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("src/words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert in != null;
        List<String> words = in.lines().collect(Collectors.toList());
        List<List<String>> anagram_list = new ArrayList<>();
        HashMap<Integer, List<String>> anagram_map = new HashMap<>();
        for (String word : words) {
            int anagram_number = evaluate(word, letter_code);
            if (anagram_map.containsKey(anagram_number)) {
                anagram_map.get(anagram_number).add(word);
            } else {
                anagram_map.put(anagram_number, new ArrayList<>(Collections.singleton(word)));
            }
            if (anagram_map.get(anagram_number).size() >= 2) {
                anagram_list.add(anagram_map.get(anagram_number));
            }
        }
        anagram_list.stream().filter(list -> list.size() == 10).distinct().forEach(System.out::println);
    }

    static int evaluate (String s, HashMap<Character, Integer> code) {
        int result = code.get(s.charAt(0));
        if (s.length() > 1) {
            for (int i = 1; i < s.length(); i++) {
                result *= code.get(s.charAt(i));
            }
        }
        return result;
    }

}
