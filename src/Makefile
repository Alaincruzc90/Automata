# only works with the Java extension of yacc: 
# byacc/j from http://troi.lincom-asg.com/~rjamison/byacc/

JFLEX  = jflex 
CUP = java -jar java-cup-11b.jar
JAVAC  = javac -cp .:java-cup-11b-runtime.jar
RUN = java -cp .:java-cup-11b.jar Main

# targets:

all: FINAL.txt

run: FINAL.txt

build: clean Yylex.java

clean:
	rm -f *~ *.class *.java

Yylex.java: wheels.flex
	$(JFLEX) wheels.flex

Parser.java: yanaliz.cup
	$(CUP) yanaliz.cup

Main.java: Yylex.java Parser.java
	$(JAVAC) Main.java

FINAL.txt: Yylex.java Parser.java Main.java
	$(RUN) FINAL.txt
