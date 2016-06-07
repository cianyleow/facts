# FACTS
FACTS API

Installation
------------
This installation guide is written for a Debian/Ubuntu based system. Specifically, an AWS Ubuntu 14.04 instance was used in June 2016, so please note that certain programs and commands may change over time.

1. Add the Oracle Java 8 dependency to the APT repository
  1. `sudo add-apt-repository ppa:webupd8team/java`

2. Update the APT environment
  1. `sudo apt-get update`

3. Install the necessary software for the API to run
  1. `sudo apt-get install nginx git mysql-server oracle-java8-installer`
  2. You will need to set a password for the MySQL server here and accept the Oracle Java 8 license agreements.
    1. Please choose a suitably complex password.

4. Run some commands to secure the MySQL server installation. Follow the on-screen instructions.
  1. `mysql_secure_installation`
  2. `mysql_install_db`
  
5. Clone the latest FACTS repository and build it locally with a Gradle Wrapper command.
  1. `git clone https://github.com/cianyleow/facts`
  2. `cd facts/facts`
  3. `./gradlew build`
  4. `cd ../..`
  5. `mv facts/facts/build/libs/facts-0.0.1-SNAPSHOT.jar ./`
  6. `chmod 500 facts-0.0.1-SNAPSHOT.jar`
    1. This sets the security level for the application. 

6. Set up the database by running the `Install-DB.sql` file. You will need to create a user and database first.
  1. `mysql -u root -p`
  2. Enter your password and you will enter the MySQL shell. Execute commands from here in this shell.
  3. `CREATE USER 'facts'@'localhost' IDENTIFIED BY '#PASSWORD#';`
    1. Please choose a suitablly complex password.
  4. `CREATE database facts`;
  5. `USE facts;`
  6. `source Install-DB.sql`



7. 
