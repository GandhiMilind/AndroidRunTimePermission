# AndroidRunTimePermission
This Project will reduce the code for permission on runtime. It is the simplest way to write code for run time permission..


To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.GandhiMilind:AndroidRunTimePermission:-SNAPSHOT'
	}