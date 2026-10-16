##Hangman-Spiel

Einfache Terminalimplementierung in Java.


Der Computer wählt ein Wort. Du siehst im Terminal wie lang das Wort ist anhand der leeren Kästchen.
Ziel ist, das Wort zu erraten.
Tippe pro Runde im Terminal einen Buchstaben ein von dem du denkst, dass es im Wort vorkommt.

Wenn der Buchstabe in dem Wort des Computers vorkommt, dann werden die leeren Kästchen im Wort mit deinen erratenen Buchstaben ausgefüllt. 
Wenn der Buchstabe nicht im Wort vorkommt, dann wird er in die Liste "incorrect letters" eingetragen und deiner freien Fehlversuche minimiert sich um eins. 
Du hast nur 8 Fehlversuche, danach hast du verloren. 
