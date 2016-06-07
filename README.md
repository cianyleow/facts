# FACTS
FACTS API

Production Installation
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

4. Run the commands to secure the MySQL server installation. Follow the on-screen instructions.
  1. `mysql_secure_installation`
  2. `mysql_install_db`
  
5. Clone the latest FACTS repository and build it locally with a Gradle Wrapper command.
  1. `git clone https://github.com/cianyleow/facts`
  2. `cd facts/facts`
  3. `chmod u+x gradlew`
  4. `./gradlew build`
  5. `cd ../..`

6. Create the user to run the application as and file system location to reside in.
  1. `sudo add user facts`
    1. Configure this user with a secure password.
  2. `sudo mkdir /var/facts`
  3. `sudo mv facts/facts/build/libs/facts-0.0.1-SNAPSHOT.jar /var/facts/`
  4. `sudo chown facts:facts /var/facts/facts-0.0.1-SNAPSHOT.jar`
  5. `sudo chmod 500 /var/facts/facts-0.0.1-SNAPSHOT.jar`

6. Set up the database by running the `Install-DB.sql` file. You will need to create a user and database first.
  1. `mysql -u root -p`
  2. Enter your password and you will enter the MySQL shell. Execute commands from here in this shell.
  3. `CREATE USER 'facts'@'localhost' IDENTIFIED BY '#PASSWORD#';`
    1. Replace #PASSWORD# with a suitably complex password.
  4. `CREATE database facts`;
  5. `GRANT INSERT, DELETE, SELECT, UPDATE ON facts.* FOR 'facts'@'localhost'`
  5. `USE facts;`
  6. `source facts/Install-DB.sql`

7. Create the uploads folder and secure it.
  1. `sudo mkdir /var/facts/upload`
  2. `sudo chown facts:facts /var/facts/upload`
  3. `sudo chmod 600 /var/facts/upload`

8. Configure the specific application properties
  1. `sudo mv /home/ubuntu/facts/application.properties /var/facts/application.properties`
  2. `nano /var/facts/application.properties`
    1. Edit the details and set the MySQL facts user password, upload location (if different to above) and the JWT secret. 
    2. The JWT secret can be generated with the following command:
      1. `openssl genrsa -des3 256`
        1. Please choose a suitably strong passphrase.
      2. Copy the key itself, which looks like the below:
        1. `FFhdIezDCRo79SwavHcwqcPdCoAxM88h1LdPQYbWgENzwPotRygOcf69wQX2h+gLMRBGbstX1Ce0F57Vf0+zINIEshex5ZtegirXDsxeT39r3dadUSk4sHuT06qcPT2sdB+RNDJeVnbyFkJocJ3331yqW7buiue4UZDwItzVeJnDH4xePDgByiQHDfnQR5D7LBA5s5c3TdNJdnim7NqNYL0zcC/J997oOUhB6GJFgCM=`
  3. `chown 400 /var/facts/application.properties`
  4. `chmod 400 /var/facts/application.properties`

9. Install the application as a system service in init.d
  1. `sudo ln -s /var/facts/facts-0.0.1-SNAPSHOT.jar /etc/init.d/facts`
  2. `sudo mkdir /run/facts`
  3. `sudo chown facts:root /run/facts`
  4. `sudo su facts`
    1. Become the user facts and then start the facts application.
    2. `/etc/init.d/facts`
    3. Then use `exit` to go back to being your standard user.

10. Install SSL certificates for server security.
  1. Create self signed certificates:
    1. `sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/facts.key -out /etc/ssl/certs/facts.crt`
    2. `sudo openssl dhparam -out /etc/ssl/certs/dhparam.pem 2048`
  2. Install existing certificates:
    1. `/etc/ssl/certs/facts.crt`
    2. `/etc/ssl/private/facts.key`
    3. `/etc/ssl/certs/dhparam.pem`

11. Configure NGINX to operate as a reverse proxy and deliver the application over SSL.
  1. `sudo cp /home/ubuntu/facts/nginx/facts /etc/nginx/sites-available/`
  2. `sudo cp -r /home/ubuntu/facts/nginx/snippets /etc/nginx`
  3. `sudo ln -s /etc/nginx/sites-available/facts /etc/nginx/sites-enabled/`
  4. `sudo nginx -t`
  5. `sudo service nginx restart`
