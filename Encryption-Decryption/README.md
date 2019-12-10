An encryption-decryption project based on two differents algorithms the user can choose from to encrypt/decrypt his message.

The Alphabet-circle algorithm : reads an English message and an integer number (key) from the console and shifts each letter by the specified number according to its order in the alphabet. 
If it reaches the end of the alphabet, it starts back at the beginning (a follows z).
If the user choses to decrypt the message instead of encrypting, the programs goes through the alphabet circle in the reverse order (from Z to A).

The Unicode-based algorithm : reads an English message and an integer number (key) from the console and modifies each letter by the specified number according to its order in the Unicode table. 
If the user choses to decrypt the message instead of encrypting, the programs goes through the Unicode table in the reverse order (from end to beginning).

The program has the ablity to read the data and write the result to a file. A typical way to execute the program in the console would be : 

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
java Main -key 5 -alg unicode -data "Welcome to my GitHub" -mode enc

-mode : to encrypt or decrypt (enc / dec)
-in : to precise if the data comes from a file
-out : to precise if we want to write the result in a file
-key : the number used to encrypt / decrypt the mesasage according to the alphabet or unicode table
-alg : to choose the desired algorithm, alphabet (shift) or unicode (unicode)
-data : to precise the text to encrypt / decrypt if it's not coming from a file.

Note that not all arguments have to be specified, the default settings will be used if not specified.
Default setup:

-mode : enc.
-in : not used. Input is entered manually by the user (-data).
-out : not used. Result is displayed in the console / IDE.
-key : 0 (the program will return the input text without changes).
-alg : shift.
-data : empty string.
