SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_111\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\Fuentes\jflex-1.4.3
cd C:\Users\Ramonella\Documents\Repositorios\Proyecto1\NavegadorWeb\proyecto1_201122872\src\proyecto1_201122872\AnalizadorCJS
java -jar %JFLEX_HOME%\lib\JFlex.jar ScannerJS.jflex
pause

