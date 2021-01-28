# AnagramFinder
A program that prints anagram lists from words in a text file.

The program works by assigning a prime number to each letter used in the english language. Each word is then evaluated by multiplying letter values. Words which have the same value are anagrams, words which have the same letters arranged in different order. Anagrams from the text file are then put together into a list and printed out. Provided text file contains roughly 110 000 words. That's why program prints only distinct list of size 10. User can easily change that by modifying a condition in line 44. 
