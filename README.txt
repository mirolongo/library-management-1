Teknikhogskolan
Project v.2
20/10/19 - 20/11/10

Contribution:

Dennis Tran
Waldomiro Longo

LINKS:

Repository: https://github.com/dennistran4/library-management

INFORMATION:

A basic library management system with a database in the form of a serialized .txt file that can be manipulated via commands. Developed in JAVA via IDE Eclipse with writing in file in byte-code format.

The system is run via console and does not have any integrated graphics application, so it does not need installation for its execution.
The system can be run via an IDE and via CMD.

SETTINGS

The library system does not have configuration files, so the system settings are embedded in the code and with very little relevance to the user.

PROGRAME

This library management system allows the user to register/deregister both books and movies, depending on which product extra information from the user is needed. User also have the ability to checkin/checkout products to a customer, this information is also stored. A product in the system is limited to one customer but customers may checkout any desired amount of products.

The user interacts with the program via a console and input commands.
the following information is needed to operate the program;

These are the needed information for registrering Books.
	-Unique code
	-Title
	-Number of pages
	-Value
	-Publisher

These are the needed information for registrering Movies.
	-Unique code
	-Title
	-Duration
	-Value
	-Rating

COMMANDS
Note; the commands have to be lowercase letters.
The following usuable commands are;

list 				 = presents all register products in the system.
checkout + (article code)	 = lend a product to a customer.
checkin + (article code) 	 = return a loaned product.
register 			 = register a new product either book or movie.
deregister + (article code)	 = deregister a product from the system.
info + (article code)		 = informs the status of the product and the in-depth description of the item.
quit 				 = exits system.	
