# Y2S4DSA_WordCloudGenerator

Author:
Eoin Wilkie

Project:
Project: A Word Cloud Generator

Description: Console menu requests fileIn, wordCount and fileOut. Loops until user requests exit by inputting N/n.

HashMap<String,Integer> created from the fileIn, parsed by Parser, and filtered with ignoreWords.txt. Additional checks to eliminate non-words are made for both files and HTML. HashMap is placed on a PriorityQueue as Word objects using WordComparator to order.

WordCloudGenerator is called with PriorityQueue arguments. Words are placed on the image. First placement is always central, afterwards words are placed within sections of the wordCloud around this first word until the available space is filled and then the placeable space is increased. This is done inefficiently with random placement used but it works with collision checking to ensure words are not overlapping.

Word objects are given created with (word, count) arguments, additional variables include weight, which determines the size of the word on the cloud. Aswell as functions to determine the word image parameters. Words also have collisionCheck.
