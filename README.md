# Compile
Compilation is done using Maven tool. To compile execute on your terminal `mvn clean package` in the directory where _pom.xml_ is.

# Run
After compilation execute:  
`java -jar target\elevatorsystem.jar <number_of_floors> <number_of_elevators>`  
where <number_of_floors> and <number_of_elevators> are optional integer parameters. Type "help" to view available commands.
