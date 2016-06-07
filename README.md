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
4. Run some commands to secure the MySQL server installation. Follow the on-screen instructions.
  1. `mysql_secure_installation`
  2. `mysql_install_db`
5. Set up the database by running the `Install-DB.sql` file. This will prompt you for a user password, which you will need to use for the application.
  1. `mysql -u root -p < Install-DB.sql`
6. Clone the latest FACTS repository and build it locally with a Gradle Wrapper command.
  1. `git clone https://github.com/cianyleow/facts`
  2. `cd facts/
