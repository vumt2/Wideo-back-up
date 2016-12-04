# WideoVideo-cmsc355-android-app

Iteration 1:

-In this iteration, we created the basic UI for our app. We can mostly navigate around the activities using the current UI. We will implement more functions to it in later iterations. 

-The camera activity (the activity linked to Record button) works best with API 21. The Nexus 5X API 24 (Nougat) couldn't even open its built in camera so it wouldn't work with this app.

-The settings activity doesn't change the camera's values yet. It contains the buttons for now. Since it isn't completed, we didn't close the user story 2, we will continue to work on it in later iterations.

-The Espresso tests should be run individually. When bundled together, they don't run very well (may be it only happens on my emulator).

Iteration 2 

-Share button is working fine but our emulator doesnt have the share apps (Facebook, Dropbox, etc) that are supposed to show up on the screen when Share button is pressed. The tutorials that taught me the methods to do the share button did it in a similar way and it is working fine. Other than that, the share button code is working if it was on a real phone that has other sharing apps. 

-The exit button now opens a dialog which asks the user to choose whether they really wants to exit or not.

-The record button now can start mediarecorder.

-Gallery and contact list are now working properly.

-Setting gets more options: flash, quality, share, etc.

-Map function is available.

-all capital "CMSC355Wideo.Wideo" folder names need to be changed to lowercase "cmsc355.wideo.wideo" otherwise you will get an error when 
installing APK. (Despite numerous commits, and refacoring we were not able to change this. Looking for a solution for the next iteration) 

Iteration 3:

-Share button has better function now. It allows the user to pick a video then send it as data via the app they choose.

-Contact list was improved. Now it not only shows the contact picked, it also sends an invitation via SMS manager to the chosen contact.
We moved the unfinished contact list user story from milestone 2 to milestone 3 and marked it as finished (closed).

-There are home buttons in Settings, Quality, Flash screens so the user can quickly go back to home screen.

-JUnit tests are writen and working on my PC. I'm not sure the pulled version from Git can work properly because the problem from 2nd iteration has not been resolved (we tried many things but still couldn't change the package name on Git).

-We reorganized the buttons, resized them and moved them around the activities so the UI looks better.
