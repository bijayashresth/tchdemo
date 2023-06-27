# TCH demo

TCH Demo is a demo applicaiton to read data from the file and search based on
a. By Zip code or State or City or Type or Bank Name
b. By City & State

Prerequisite : 
	A CSV file with following format
	Row 1 : Header 
		ID	|	Bank Name	|	Type	|	City	|	State	|	Zip code
	Row 2... : Data
	
Usage :
Run the application and application will prompt for the path and options : 
Main class : com.tch.demo.MainClass
Example : 

CSV file path : <File absolute path>
Search by (Please slelect one of (name | zipcode | state | city | type | cityandstate)  : name (For example)
Search for value name : Neighborhood Bank
Response : [Bank [id=2, name=Neighborhood Bank, type=Branch, city=New York, state=NY, zipCode=10020], Bank [id=6, name=Neighborhood Bank, type=ATM, city=Winston-Salem, state=NC, zipCode=27105], Bank [id=8, name=Neighborhood Bank, type=Branch, city=Winston-Salem, state=NC, zipCode=27107]]