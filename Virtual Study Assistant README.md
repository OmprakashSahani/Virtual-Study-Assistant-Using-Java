# Virtual-Study-Assistant-Using-Java
The Virtual Study Assistant is a Java-based desktop application designed to help users manage their study tasks effectively. 

The Virtual Study Assistant is a Java-based desktop application designed to help users manage their study tasks effectively. With features such as task management, overdue notifications, and completed/pending task views, this tool simplifies task organization for students and professionals.

Features:

1. Add Tasks: Add new tasks with descriptions and deadlines.

2. Mark as Completed: Mark tasks as completed once done.

3. Delete Tasks: Remove tasks from the list.

4. View Tasks: View all tasks, pending tasks, completed tasks, or overdue tasks.

5. Persistence: Automatically saves tasks to a file (tasks.dat) and reloads them when the application is restarted.

6. Overdue Notifications: Identify tasks that are overdue.


Installation:

1. Prerequisites:

Java Development Kit (JDK) 8 or higher.

An IDE like BlueJ, IntelliJ IDEA, Eclipse, or a terminal to compile and run Java programs.


2. Clone the Repository:

git clone https://github.com/your-repository-url/virtual-study-assistant.git
cd virtual-study-assistant


3. Compile the Code:

Open the project in your IDE or compile manually:

javac *.java


4. Run the Application:

java StudyAssistantGUI



Usage:

1. Adding a Task:

Enter the task description.

Input the deadline in the format yyyy-MM-dd HH:mm.

Click the Add Task button to save the task.



2. Managing Tasks:

Select a task from the list to mark it as completed or delete it.

Use the respective buttons to manage the selected task.



3. Viewing Tasks:

Click View Pending Tasks to see tasks that are pending and not overdue.

Click View Completed Tasks to see completed tasks.

Click View Overdue Tasks to identify overdue tasks.



4. Overdue Check:

The app highlights overdue tasks automatically.




File Storage

Tasks are saved in a file named tasks.dat located in the application's working directory.

The file ensures data persistence across sessions.



Dependencies:

Standard Java Libraries (java.io, javax.swing, java.util, etc.)


License:

This project is licensed under the MIT License. See the LICENSE file for details.


