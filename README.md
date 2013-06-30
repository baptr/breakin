BreakIn: The Sheepening<br>_Little Bo Peep's Revenge_
====================
Android game (more to come)

Building and Running
--------------------

### Desktop
Desktop builds should be easy.

    $ git clone https://github.com/baptr/breakin.git
    $ cd breakin/desktop
    $ ant run

### Android
Android build is uglier and more complicated.
If you don't already have the Android SDK, [download it](http://developer.android.com/sdk/index.html) and get it set up.

Once that's done, the build itself isn't too bad...

    $ git clone https://github.com/baptr/breakin.git
    $ cd breakin/android
    $ echo "sdk.dir=/LOCATION/OF/UNPACKED/ANDROID/SDK" >> local.properties
    $ ant debug

With any luck, you'll end with "Success" and be able to `ant installd`.

### Eclipse Setup
There are a couple steps to get everything set up and imported into an eclipse workspace

##### Configuration

* Window->Preferences->Java->Code Style->Formatter->Edit->Indentation = "Spaces Only" (4 spaces)

##### Install 

* Click Help > Install New Software.
* Choose "--All Available Sites--" from the drop down
* Search for and install Eclipse EGit

##### Download code

* File > Import > Git > Projects from Git > URI
* Copy git url in the URI box `https://github.com/<username>/breakin.git`
* Click Next a few times
* Import existing projects > Check Breakin
* Read through [this EGit documentation](http://www.vogella.com/articles/EGit/article.html) for more info

##### Set up JDK

* Click Window > Preferences > Java > Installed JREs
* Add `\Program Files\Java\jdk1.7.0_10`
* Uncheck the JRE box and check the JDK that was added

##### Build + Run

* Right click the build.xml you want to run > Run As > Ant Build
* Right click DesktopGame.java > Run As > Java Application
* This will automatically create a Run Configuration for the desktop version of the game
* Click Run > Run Configuration > DesktopGame > Classpath > User Entries > Advanced > Add Folder
* Add Main > Assets
* Re-run game

Credits
-------
