# MyPokerSolution
This is a poker solution project.
It accepts input from text file (eg: PokerInput.txt) and determine the winner.

sample file content 

	7D JC 5S 9S 4D 3D TS AC 2S QD
	8C AH 5H KH 7H 4H 2H QS AS 8D
	5C 8D 7S 3D JC JS 4H JH 9S 5H
	8C 3S 5C JC 3D TH 2S 3H 7H 4H
	
sample output

	Player1 :53 Hands
	Player2 :67 Hands

## Build and Deploy
Compile the solution
Create a runnable Jar with the following configuration in the manifest

	Main-Class: org.poker.pokergame.PokerGame

## How to run in Windows

Place the jar and input file in the same folder
Execute the below command from CommandLine

	java -jar poker.jar < PokerInput.txt
		
## Unit Test
	Unit tests has been done only for Poker Rules.


