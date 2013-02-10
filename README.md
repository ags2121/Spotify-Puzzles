Spotify-Puzzles
===============

Answers to current Spotify puzzles:

<h4>Reverse Binary:</h4>
<b>Task</b><br>
Your task will be to write a program for reversing numbers in binary. For instance, the binary representation of 13 is 1101, and reversing it gives 1011, which corresponds to number 11.

<b>Input</b><br>
The input contains a single line with an integer N, 1 ≤ N ≤ 1000000000.

<b>Output</b><br>
Output one line with one integer, the number we get by reversing the binary representation of N.

<h4>Zipfsong:</h4>
<b>Task</b><br>
"...To illustrate this in our setting, suppose we have an album where all songs are equally good. Then by Zipf’s Law, you expect that the first song is listened to twice as often as the second song, and more generally that the first song is listened to i times as often as the i’th song. When some songs are better than others, those will be listened to more often than predicted by Zipf’s Law,  and those are the songs your program should select as the good songs. Specifically, suppose that song i has been played fi times but that Zipf’s Law predicts that it would have been	played zi times. Then you define the quality of song i to be qi = fi / zi. Your software should select the songs with the highest values of qi."

<b>Input</b><br>
The first line of input contains two integers n and m (1 ≤ n ≤ 50000, 1 ≤ m ≤ n), the number of songs on the album, and the number of songs to select. Then follow n lines. The i’th of these lines contains an integer fi and string si, where 0 ≤ fi ≤ 1012 is the number of times the i’th song was listened to, and si is the name of the song. Each song name is at most 30 characters long and consists only of the characters ‘a’-‘z’, ‘0’-‘9’, and underscore (‘_’).

<b>Output</b><br>
Output a list of the m songs with the highest quality qi, in decreasing order of quality. If two songs have the same quality, give precedence to the one appearing first on the album (presumably there was a reason for the producers to put that song before the other).
