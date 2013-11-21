robocode-jgap-template
======================

Simple project to get JGAP [ http://jgap.sourceforge.net/ ] up and running with Robocode [ http://robocode.sourceforge.net/ ]

To set up project in eclipse you must be using JE6 or less and include both robocode.jar and jgap.jar into the project [ downloadable from the links above ]

src/robocodeGA.java
---------------

This is the main logic for the program. It includes all of the JGAP stuff as a sample to create chromosomes from genes and evolve through generations from the best of each population

src/createRobo.java
---------------

This file is used to write and compile the robot for battle in robocode. It receives an array of the values once they have been passed through JGAP. The values can then be used in writing the logic for the bot

src/battleObserver.java
-------------------

This is the file which watches the battle and passes the results back to the main program. Very simple logic currently to get which robot scores the higest amount of points in the battle. Can be extended to get hits/misses etc

--- somee code in this file I found from another project online... I don't remember where it was though. If you find it send me a message and I will include credit ---

robots/custom/samBot.java
---------------------

Generated robot file from the program. This is compile to samBot.Class which is used to battle other robots for evolution

****************************

I wrote this a few years ago as a university project.
It is by no means the best way to approach this problem, however I found setting up the environment to be a very challenging task so this can be used as starting blocks for any project...

If you come up with anything to add, or create something awesome please share it with me or contribute, it would be cool to see!
