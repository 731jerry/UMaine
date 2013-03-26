#!/usr/bin/python


#this file will go through all the sites and pull the data for the opponent and time for the game for each team
#results are stored in schedule.csv in the same directory as this script file

import re
from urllib import urlopen


#create the csv file named schedule.csv
text_file = open("schedule.csv","w")

#array of sites
url=['m-basebl/2011-12/schedule','m-baskbl/2011-12/schedule','m-xc/2011-12/schedule','m-footbl/2011-12/schedule', 'm-hockey/2011-12/schedule','m-swimonly/2011-12/schedule','m-track/2011-12/schedule','w-baskbl/2011-12/schedule','w-xc/2011-12/schedule','w-fieldh/2011-12/schedule','w-hockey/2011-12/schedule','w-soccer/2011-12/schedule','w-softbl/2010-11/schedule','w-swimonly/2011-12/schedule','w-track/2010-11/schedule']

#loops through all of the websites and converts the length of the array to an integer used to access the array
for j in range(len(url)):

#all sites start with  "http://www.goblackbears.com/sports/" so it is concatenated to the array elements
	thisurl='http://www.goblackbears.com/sports/'+url[j]
	print thisurl

#opens a page and stores the data to page
	page=urlopen(thisurl).read()

#removes all repeated whitespace, and leaves a single space in its place

	page = " ".join([line.strip() for line in page.split("\n")])
	#remove all commas to keep the columns intact when a state is listed (ie Bangor, ME)
	page = " ".join([line.strip() for line in page.split(",")])

	page = " ".join([line.strip() for line in page.split("*")])

	#page = " ".join([line.strip() for line in page.split("&nbsp; ")])  #&nbsp; 
#define regular expression for parsing the data
	opponent_re = re.compile('<div class="opponent">(.*?)</div>')
	date_re = re.compile('<div class="date">(.*?)</div>')
	time_re = re.compile('<div class="time">(.*?)</div>')
#create lists for opponent and date data
	opponent_list=re.findall(opponent_re,page)

	date_list=re.findall(date_re,page)

	time_list=re.findall(time_re,page)

#pull from the url the date and the team
	year_re=re.compile('\d{4}\-\d{2}')
	year=re.search(year_re, url[j])
	team_re=re.compile('\w+\-\w+')
	team=re.search(team_re,url[j])
	
	

	 

	for i in range(len(opponent_list)):

	
		if opponent_list[i]!="Name": #repress the name, date, time headers
			
			#execute the next two lines if the opponent_list is not pointing to 'Name'
			
			
			if date_list[i]!=" &nbsp; ":#repress printing a line with &nbsp
				#print the data to the file pointed to by text_file
				print >>text_file,opponent_list[i],',',date_list[i] , (year.group()),',',time_list[i],',',(team.group())

				#prints to screen the same data 
				print opponent_list[i],',',date_list[i] , (year.group()),',',time_list[i],',',(team.group())

text_file.close()

	
	
	
	

	
		
	
