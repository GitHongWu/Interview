Environment:
	python 3.x

Requirement pack(s):
	beautifulsoup4	4.9.3
    soupsieve		2.1

Instructions: 
	running with command: python Main.py

Command:
	python Main.py

By given the stock code,this application displays the stock information from https://finance.yahoo.com.
Basic stock information include stock name, low and high price in a day, open and previous close price.
The graphic user interface is using python3 built-in package 'tkinter, searching and scraping data from
yahoo.com is using package 'beautiful soup 4'

The application handles different user input:
1. stock code can either be upper or lower case, such as 'ISRG' or 'isrg'
2. stock that does not exist, such as 'aaaaaaa'
3. stock exists, but has no data, the application will display 'N/A', such as 'SIGR'
4. empty input form user
