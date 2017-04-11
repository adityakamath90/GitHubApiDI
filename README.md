# GitHubApi

A background about design and architecture in the application

1. 	I have implemented Model View Presenter (MVP) architecture in the application for seperation of layers. Salient 	features of MVP are as follows

		The model
			The model is the provider of the data we want to display in the view.	

		The View
			The view is implemented by an Activity contains a reference to the presenter. The view calls a method 			      from the presenter every time there is an interface action (a button click for example)

		The presenter
			Presenter is responsible to act as the middle man between view and model. It retrieves data from the    
			model and returns it formatted to the view.It also decides what happens when you interact with view.

2.	Packages are divided according to feature.
		repositoryLanguage  - Screen to enter the programming language
		repositoryList      - Screen displaying list of respoitories for a programming language
		repositoryDetail    - Screen displaying the contributors and issues.


3.	Unit Testing
		I have used Mockito for testing the Presenter and the model classes.

4 	Instrumentation Testing
		I have used AndroidJunit4 and expresso for UI testing (LanguageActivity) only
