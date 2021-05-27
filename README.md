
#swagger ui added

A RESTFull API to maintain a journal of calories burned daily during the runs. 
Endpoints:
- create profile (age, weight, username) 
- get calories burned for an activity for my profile 
- add exercise instance with speed and time (compute calories and update database) 
- get total calories burned between date x and date y 
- remove exercise instance 
- update exercise instance 
- remove profile (removes all exercise instances) 
- update profile (previous exercise instances won't change only the new ones will be computed as pr new profile)
