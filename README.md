# Poker Card Game v2

Poker Card Game v2 is an immersive and strategic Java card game designed to captivate players seeking thrilling challenges. Engage in intense rounds against a clever dealer, strategically betting chips and leveraging card values to secure victory. Experience the thrill of the shuffle, the rush of making critical decisions, and the excitement of outplaying the competition in this high-stakes, multi-round showdown. Sharpen your wits, master the cards, and claim your place as the ultimate Poker champion!



# **Prerequisites**


> 1.  **Java Development Kit (JDK)**: Ensure you have Java installed on your system. You can download and install it from the official Oracle Java website.

> 2.  **Install Visual Studio Code:** Download and install Visual Studio Code from its official website. VSC is available for Windows, macOS, and Linux.


## 
1.  **Setup Environment:**
    
    -   Open up Visual Studio Code, import all the folders into the source-code editor.
2.  **Install relevant extensions**
    
    -   Install relevant extensions under Extensions on the left column to debug the code upon running, few available extensions are:
   ```bash
		    Debugger for Java
```
```bash
		Extension Pack for java
```
  

3. **Run the Program:**

    -   Once the installation is successful, execute the Java program. Run the following Java program under src folder:
```bash
		 GameModule.java
```        
   
# **Graphical User Interface**

- Upon running the file, a GUI will pop up requesting for an existing Username and Password.

  ![image](https://github.com/linzele/Card-Game-v2/assets/154880136/4f82b3ea-434d-469c-ac99-a78720a5b556)


- After keying the right details, you will be brought over to the game lobby! Enjoy~!

  ![image](https://github.com/linzele/Card-Game-v2/assets/154880136/12aa12e7-8d80-4f21-b244-11f3e8cad373)

## Game Functions (Administration Module)

**Objective:** The primary goal of the Administration Module is to enable administrators to manage player accounts and game settings efficiently. It offers functionalities related to player account creation, deletion, viewing player details, managing chips, and changing passwords.

**Admin Functions:**

1.  **Create a Player:**
    -   Allows the creation of new player accounts by specifying login names, hashed passwords (in SHA-256), and initial chip amounts.
2.  **Delete a Player:**
    -   Enables the deletion/removal of existing player accounts from the game.
3.  **View All Players:**
    -   Displays a list of all registered players along with their login names, hashed passwords, and chip balances.
4.  **Issue Chips to a Player:**
    -   Allows administrators to add more chips to a player's account.
5.  **Reset Player’s Password:**
    -   Provides the ability to reset a player's password.
6.  **Change Administrator’s Password:**
    -   Allows the admin to update their own password.
7.  **Logout:**
    -   Logs the admin out of the Administration Module.
## User Details (Stored in Player.bin)



| Login Name | Password in SHA-256|  Chips|
| ----------------------------- | ------------------------------- | ---------------------------|
|IcePeak| **5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8**|1000


## Admin Details (Stored in Admin.txt)

Refer to Admin.txt

- Link to decrypt SHA-256: **https://md5decrypt.net/en/Sha256/**


