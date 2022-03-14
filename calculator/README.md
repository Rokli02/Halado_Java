# calculator-base


Feladat egy szamologep leprogramozasa egy maven projektben. 
Kulso fuggosege csak a Junit megfelelo veerzioja.

A szamologep alap muveleteket tud, bemenetrol dolgozik kimenetre ir.

A github teszteli is az alkalmazasod.

Elvert mukodes:
- a futtathato osztaly teljes neve: hu.meiit.haladojava.calculator.App
- hiba eseten "-" a kimenet (nincs feher karakter)
- normal esetben a kimenet az eredmeny 1 tizedesjegy pontossaggal (nincs feher karakter)
- operator es operandusok kozott vagy van space, vagy nincs

tesztek
mvn package

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "3 + 4",
"output": "7.0",

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "aa",
"output": "-",

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "6*4",
"output": "24.0",

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "9 / 2",
"output": "4.5",

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "6/0",
"output": "-",

"run": "mvn -q exec:java -Dexec.mainClass=\"hu.meiit.haladojava.calculator.App\"",
"input": "12 - 5",
"output": "7.0",


Megprobalja lebuildelni a java projektet (mvn package), ami elott lefutnak a tesztek is ha vannak a kododban.
Bukik a build, ha nem tudja a maven leforditani a projektet.

Miutan lefordul futnak le a kulso tesztek.

Honnan tudom, hogy az adott commit jo-e:
https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/collaborating-on-repositories-with-code-quality-features/about-status-checks

Ha a kulso tesztek nem sikeresek, akkor igy tudod megnezni, hogy mi a baj:
https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results

