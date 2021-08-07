# TableBuilder
CLI application for building tables from CSV documents

## Usage

### Default
You can invoke the app by using `java -jar TableRenderer.jar -i <path/to/input> -o <path/to/output>`

The arguments are in the following table:
Name | required | type | default    
-----|----------|------|------------
-i   | no       | Path | "./in.csv"
-o   | no       | Path | "./out.txt"

<sub><sup>yes, this table was generated using the software</sup></sub>

The Program also prints the result to stdout, so you could pipe it or read it directly from another software.

### Shell script
#### Windows:
The following command can be placed in a batch script to launch the program without having to call the java file
```
java -jar TableBuilder.jar %*
```

you can even add it to your PATH if you want to use it everywhere

#### Linux:
The following command can be placed in a shell script to launch the program without having to call the java file
```
#!/bin/bash
java -jar TableBuilder.jar $*
```

## Instalation
### Precompiled Executable:
You can download the precompiled Executable jar from the releases page on github

### Build
in order to build it yourself:

1. Download the code and place it in a directory 
2. run the following commands in order on the root directory:
```bash
mkdir build
javac Main.java -d ./build
cd build
jar cmvf ../manifest.mf TableBuilder.jar *.class
```
3. now you have TableBuilder.jar in your directory


## Credits
TableRenderer.java was not written by me, credits to:
- https://github.com/ekgame/storasbot
- https://github.com/ekgame/storasbot/blob/master/src/main/java/lt/ekgame/storasbot/utils/TableRenderer.java

I modified the code in order to use only default java libraries and to generate a markdown table instead
