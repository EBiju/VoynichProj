# VoynichProj
This project will attempt to decipher page 7r from the Voynich Manuscrupt. The image is from the Yale University Library. Within it, I take the computer readable text and attempt to decrypt it.Here are the steps I took and my results:
   1. I Set up a text file based containing the text from the page in english. The english is made 
   to closely resemble the actual text within the page.
   2. Then I set up a dictionary of words to look for when attempting to decipher the text. The 
   words I chose specifically included languages spoken during the time of creation of the Voynich 
   manuscript; Spanish, Latin, Italian, and French. Because the page to me is shaped like a poem,
   I decided to use words that would be commonly seen in a poem. Words are time, love, world, and 
   day
   3. With the computer readable and dictionary texts, I put them through a brute force shift 
   decryptor to see if I could find any of the dictionary or english word. This was done using a   
   counter control for loop to go through every kind of alphabetical shift beginning at 0 to 25, 
   the maximum amount of shifts you can make before landing on square one.
   4. I was unfortunately unable to find a solution or even similar words to the known European 
   languages. The text still remains to be a mystery.

#Installation
This project can be used very simply as long as you have Intellij installed. Should you have it installed, simply copy the url of this project and create a new project from Intellij using get from VCS. Paste in the url and it should give you the program for you to use and run.

#Usage
You can try to use this project as base for your own Voynich Manuscript decryption project. Simply edit the computertext and dictionary files based on your own needs, such as if you want to
do a different pages or use words in other languages.

#Credits
Source of the Voynich Manuscript Page image: https://collections.library.yale.edu/catalog/2002046 

Source for the computer text file I used to decript within the project:
https://www.voynich.nu/q01/f007r_tr.txt

Source of the layout and code of my project is by user Joe Oakes on Github. Here is his project
I used as a base for my own: https://github.com/joeoakes/javaConstitutionManuscript 

