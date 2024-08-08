# british-spoken-clock
This simple project is going to convert a given time into the British spoken equivalent.

Table of contents
- [Installations](#installations)
  - [JDK 11](#jdk-11)
  - [Apache Maven](#apache-maven)
- [Usage](#usage)
  - [Getting the code](#getting-the-code)
  - [Building the jar](#building-the-jar-artifact)

## Installations

### JDK 11

- We can check whether Java is already installed on your machine. Issue the below command in your terminal. If the command returns
successfully, then Java is already installed. You can skip this section.
    ```bash
    java -version
    ```
- Please ensure to have installed JDK version 11.xx.xx.
- Instructions for installing JDK on Microsoft Windows can be found [here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
- Instructions for installing JDK on macOS can be found [here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE)
- Instructions for installing JDK on Linux can be found [here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)
- Once the installation is complete the terminal will output the version of the installed JDK.

### Apache Maven
- We can check whether Maven is already installed on your machine. Issue the below command in your terminal. If the command returns
  successfully, then Maven is already installed. You can skip this section.
    ```bash
    mvn -version
    ```
- Instructions for installing Maven can be found [here](https://maven.apache.org/install.html)
- Once the installation is complete the terminal will output the version of the installed Maven.

## Usage

### Getting the code

- Issue a below command in your terminal to get a copy of the code on to your local machine
  ```bash 
  git clone https://github.com/chaitanyagprasad/british-spoken-clock.git
  ```
- Enter into the root of the cloned directory and issue a pull command
  ```bash
  git pull origin master
  ```
- The above command should get the latest code on to your local.

### Building the jar artifact

- In the root of the downloaded code issue the following command to build a jar artifact.
  ```bash
  mvn clean install
  ```
- After the command executes, you should be able to see a target folder in the root directory and under the target folder
you should be able to see `british-spoken-time-1.0-SNAPSHOT.jar`.

### Running the jar

- Move into the location where the jar file got built(probably the `target` folder).
- Once the jar file is located, we can issue the below command to start the main class in the jar
  ```bash
  java -jar .\british-spoken-time-1.0-SNAPSHOT.jar
  ```
- The jar will continuously accept time and will keep outputting the British spoken time for the inputs.
- To exit from the jar, use unix style quit `:q!` as input. 