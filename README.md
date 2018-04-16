# Competitive Programmer's Analyzer
## cp-anlyzr
Our plan is to make a Competitive Programmer's Analyzer which will take Handle _Name/username/email of an contestant and show some graphs and statistics for that Handle. We will show many graphs to present current condition of a user, his activity, progress in problem solving.

### Our Planed Features
- Verdicts chart
- Show progress chart after a training session on specific topic
- Progress of a training based on weighted average of problem hardness
- Solved problems languages chart
- Solved problems tags chart
- Solved problems levels chart
- Total tried problems count
- Total solved problems count
- Average and max attempts
- Max AC for a single problem (It indicates in how many ways someone solved a problem)
- List of unsolved problems

### We will try
- Suggestion for problems based on ones solved problem categories and hardness.
- A make activity chart show which will show how active the user is in previous months.

### Implementation Idea
We planed to build a Web App or a Desktop App using Java. Codeforces provide public APIs, through which machine-readable JSON formated data is available. We will use codeforces APIs to get data of a user by sending HTTP-request to codeforces server. There are many library to consume APIs in Java.
Some of them are:
- [httpcomponents-client-ga](http://hc.apache.org/httpcomponents-client-ga/)
- [square/okhttp](https://github.com/square/okhttp)
- [square/retrofit](http://square.github.io/retrofit/)

Making a Web App will be difficult then building Desktop App. Java Swing or JavaFx will be enough to build a Desktop App. On other side to build web based App we have to use Servlet, JSP, JDBC and a database.

### Objectives
- Determine individuals programming skill on various categories.
- Easily shows ones powerful area of problem solving categories
- One will able to know his particular weak area of problem categories.
- Will be able to know his progress through months.
- Suggested problems will be helpful to and guide a competitive programmer.

### License
The tool is given under MIT license.

