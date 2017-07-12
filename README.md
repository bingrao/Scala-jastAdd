# 1. Description

Bingbing Rao     Robin.Rao@knights.ucf.edu

This is an implementation of Scala program language based on JastAdd tools.

Directories and files:

- **AST:** Generated directory with Java code
- **spec:** JastAdd and parser specification files
- **input:** The input file that will be use in the JUnit Test Case
- **tests:** JUnit tests
- **tools:** The tools used: jastadd, junit,and parsing tools (jflex, beaver, JastAddParser).
- **utility** Define Java utility class
- **build.xml:** The ant build-file
- **README.md** Documents about this project.

To run the examples, you need the following programs installed:

- **ant**
- **javac**
- **java**

The build file supports the following targets:

- **ant gen:** generates the AST directory with Java code
- **ant build:** compiles all Java code in this directory
- **ant test:** runs the JUnit test cases
- **ant doc:** generates javadoc
- **ant genclean:** removes all generated files (the AST directory and all class files).
- **ant clean:** clean *.class files

# 2. Motivation

For now, there are so many programmers and teams have developed some useful program analysis tools for Scala language,
such as Scala Compiler, FindBugs, Scalastyle, Scagegoat and Abide. All of them are useful and resourceful. We can use these 
tools to help us debug a problem before running it. However these tools just focus on how to make scala program run 
properly on general machine, they does not care about how does an application run on a distributed system.

If we want to run our Scala program on a distributed System, for example Spark System, how to ensure our program run efficiently 
and smoothly? As we know, there are so many methods to debug a program. Symbolic debugger is a good way can help us to debug a 
program based on source code level. However it does not work when we use it to debug a distributed system. Someone would say, 
we can analyze system output, or we can put special debuggering code in the source code and get the information that we 
need when an execution incur a problem. I cannot deny that they are useful. However when we are facing distributed system,
they will make you crazy because the huge of log make it difficult for us to get the information that we need. Maybe we 
can use some log analysis tools to help us figure out this issue.  

Is there any possibility to use static program analysis to handle this problem? If we do some program analysis about 
scala program based on applications, what will happen? If we already know to use program an application to make it run 
more efficiently, we can give some experience to programmer. We can build up a tool to debug the source code to compare with
our reference module in which we already define some rules to make the application run more efficiently. For example, we can reduce
the number of Map/Reduce operations to limit the communication between nodes in a Spark System. As we know a Map/Reduce operation might 
interact with other nodes which would cause performance issue. When our application incur a straggler problem, for example, one of nodes
run slowly so that the process fail to return successfully. This kind of problem may is caused by computer network and memory issue. If 
our tools debug out the memory issue before submit application to Spark System, it will sale a lot of time. 

Based on what I have talked about, that is why I want to do some static program analysis on Scala. I know there is a long way to achieve our 
final goal. So before implement our tools, I should learn how to implement some basic program analysis about scala program language based on JastAdd,
Because JastAdd is a very useful tool to make our implementation become more easier.


# 3. Finished Work

In this project, I have implemented the following functions about Scala programming language based on JastAdd tool.  
**1. Lexical (Scanner) and Syntax (Parser)  Analysis**  
**2. Generate abstract syntax tree**  
**3. Type checking(basically)**  
**4. Available expressions analysis**  
**5. Reaching Definition Analysis**  
**6. Very Busy Expressions Analysis**  
**7. Live Variables Analysis**  

# 4. Implementation and Evaluation
## 4.1 Lexical and Syntax Analysis

In this project, I use Jflex as Scanner and use Beaver as Parser. 

Some notes about the parser:
- For parsing we use a .jflex file to specify tokens and a .parser file to specify the parsing and AST building.
- The .parser file is run through JastAddParser which is a preprocessor to beaver. The generated jflex and beaver 
files are placed in the generated AST directory.


## 4.2 Type Checking
In this project, I define a variable reference module. when we do some basic type checking, the program firstly check with the reference module to 
see the variable whether or not have been defined or inferred based on operations on that variable. 

## 4.3 Data Flow Analysis
we have implement four kinds of classical data flow analysises.

# 5. Conclusion
Through this project, I have known how compiler does work and understood some concepts about program analysis deeply. Also I know how to use JastAdd
to implement a small tool to check with our source code. What's more, Jflex and Beaver are powerful tools so that it is easier for us to scan and parse
a source code. 

# 6. Future Work

I try to use ASM tool to do some instruments about ByteCode, the object code of java and scala, to load with my application into Spark System.
In these instruments, I can debug the source code and get the information from the running system without stop the system. We can use the information
to evaluation the performance of current system. Also instruments do some program analysis to debug some subtle issues. 

# 7. Reference 
1. [Springer](http://link.springer.com/chapter/10.1007%2F978-3-642-18023-1)  
2. [Beaver](http://beaver.sourceforge.net/spec.htm)  
3. [Jflex](http://jflex.de)  
4. [jastAdd](http://jastadd.org/web)  
5. Principles of Program Analysis, Nielsen, Nielsen, and Hankin  
6. Static Type Analysis of Pattern Matching by Abstract Interpretation. Pietro Ferrara at et.  
7. Optimization and Performance Analysis of Scala over Java Compiler. Deepali Rai at el.  
8. Constructing Call Graphs of Scala Programs, Karim Ali at el  

