To run this Spring Boot application, ensure you have Java 17+, Maven 3.6+, and MySQL 8.0+ installed on your system. First, create a MySQL database named oil_tonnage_db and import the provided vcftable.sql file to populate the VCF lookup table, then run the SQL script from the repository 
code to create the oil_tonnages table. Update the dbConfig file with your MySQL credentials.
<br/>
Clone the repository, navigate to the project directory, and run mvn spring-boot:run to start the application. The web interface will be available at http://localhost:8080 where you can input volume (litres), density (kg/m³), and temperature (°C) to calculate oil tonnage, with all calculations automatically saved and viewable in the history section. 

