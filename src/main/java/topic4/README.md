# Topic 4 Questions
# 1. What is an exception’s hierarchy?
All exceptions inherit the Throwable class.
Throwable has two subclasses, error and exception.
# 2. Why do we need the exception hierarchy?
The hierarchy allows the user to define their exceptions and allows Java to organize
exceptions in a way that makes it easier to handle them.
# 3. What exception types do you know?
Checked exceptions, unchecked exceptions, and errors.
# 4. How we can throw an exception in Java?
You can throw an exception using the throw keyword and an instance of a throwable class.
# 5. How we can handle exceptions in Java (2 ways)?
You can handle exceptions by using the try-catch block or by using the try-catch-finally block.
# 6. When we can use try-catch with resources? What is the requirement?
You can use try-catch with resources when the resource implements the AutoCloseable interface.
The Autocloseable interface has a close method called when the try block is exited.
# 7. When finally block will be executed?
The finally block will always be executed after the try block is executed whether the try block caught an error or not.
# 8. Will you handle RuntimeExceptions in try-catch block?
Generally, you should not handle RuntimeExceptions in a try-catch block unless you are exception unchecked exceptions.
# 9. How to create a custom exception?
You create a class that extends the Exception class or one of its subclasses.
# 10. What is a logger? Logger levels? What log aggregators do you know?
A logger is a utility that logs messages to a file or console.
Logger levels are used to determine the severity of the message.
Splunk, ELK Stack, and Graylog are some log aggregators.

