# Victoria User Guide


![screenshot of product ](/docs/image/screenshot.png)


**Victoria** is a lightweight, offline task-tracking CLI chatbot youcan run from the terminal or inside IntelliJ.
It lets you add tasks with sub categories of deadlines, events, mark and unmark.
There is also a search, and delete with commands. 
Your tasks autosave to a file so they’re there the next time you launch.

## Adding to-dos
Adds a task into the task list.

Format:`todo [task description]`

Example:`todo sleep`

Output will give:
1. Confirmation message that task was added 
2. Example of what will appear on the list
3. Number of tasks currently in the list

```
ok added the following task bro:
[ ] sleep
now you got 1 tasks in your list.
```


## Adding deadlines

Adds a task with a deadline into the task list with a `[D]` to indicate
that it is a deadline task.

Format: `deadline [description of task] /by [deadline]`

Example: `deadline sleep /by sunday`

Output will give:
1. Confirmation message that task with deadline added
2. Example of what will appear on the list
3. Number of tasks currently in the list 

```
okies brother. I added this deadline!
[D][ ] sleep (by: sunday)
now you got: 1 tasks
```
## Adding events 
Adds a task with the category of an event to the tasks list with a `[E]` 
to indicate that it is an event.

Format: `event [event description] /from [time] to [time]`

Example `event sleep /from Monday 2pm to 4pm `

Output will give:
1. Confirmation message that event has been added 
2. Example of what will appear on the list
3. Number of tasks currently in the list

```
okies brother. I added this event!
[E][ ] sleep (from: Monday 2pm to: 4pm)
now you got: 1 tasks

```

## Feature ABC

// Feature details


## Feature XYZ

// Feature details