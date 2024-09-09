# c8-develop-workers-java-lab

I was able to create the modeler as well as a template for the JobWorker class to retrieve an image and add it to a database.
I additionally wrote code that would place an image in the database, but I did not proceed with creating a basic database for the purpose of this example, though the code should insert the record into a basic database if it exists

This is working successfully on my my docker image, as well as my Camunda SaaS environment. I haven't tested if it is successfully writing to a database (as it doesn't exist) though it is hitting my code through my debug statements
To create the test classes I would utilize JUnit to creat unit tests and ensure high code coverage.
Mockito would be used to test when utilizing the URL call to fetch an image

Generally I would confirm if tests were successfully run using System.assert to check if everything is running correctly, and successful outputs were made
I would also write integration tests using Spring Zeebe to verify the processes are run correctly, able to start correctly, and had the expected result

Additionally the job has not been "containerized and synced to my local camunda instance as of it's current state. 

I was able to deploy my Camunda model to the docker image (after going through the incorrect rabbit hole of manually creating my own instance within Kubernetes). I did not realize what the correct cluster endpoint originally was, due to originally missing it when reading hte Github repo.
A process has to manually be creatd on the Camunda Locally Managed platform to get the specific selection of a user. I have not explored why the form prompts an answer in the SaaS model, but not my local Camunda instance
I have not heavily used docker, so I was unable to containerize an image, as the previous rabbit hole mentioned of creating a Kubernetes instance utilized too much time.
I believe it is as simple as modifying the image we are able to run and simply created a new image with docker commit <identifier> <newName>


I enjoyed exploring the basics of Camunda with this excercise

I utilized FakeRandomizer, which I got from a class in Camunda Academy
I created SQLService which asssists in retrieving the image from a URL parameter, and places it in the database.
This would normally be written in a seperate class, but was created in one for testing purposes.
I did not pass the image as an encoded file through the process modeelr as that wasn't in the instructions, but I would prefer that instead of retrieving the image again in the job.


I drew a diagram that shows the Camunda job running on the Zigbee cluster, as well as the where the BPM process lives.
The diagram is called Camunda Cluster Diagram in PDF format.

I did not show the contents of the BPM diagram as it can be seen in the modeler that I have provided in the zip file in the directory FetchAnimal