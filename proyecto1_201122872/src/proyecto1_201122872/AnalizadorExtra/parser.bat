
SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_111\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\Ramonella\Documents\Repositorios\Proyecto1\NavegadorWeb\proyecto1_201122872\src\proyecto1_201122872\AnalizadorExtra
java -classpath C:\Fuentes\ java_cup.Main -parser Parser -symbols sym parser.cup
pause
