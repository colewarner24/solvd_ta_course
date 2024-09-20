# topic 9
- collections located in [inventory](https://github.com/colewarner24/solvd_ta_course/blob/main/src/main/java/internetShop/collections/Inventory.java) and [payments](https://github.com/colewarner24/solvd_ta_course/blob/main/src/main/java/internetShop/collections/Payments.java)
- reflection used in [admin](https://github.com/colewarner24/solvd_ta_course/blob/main/src/main/java/internetShop/users/Admin.java) class
# 1. What is Stream?
A stream is an abstraction of collections that allows the processing of elements.
# 2. What stream operations do you know? Why do we need them? 
non terminal
- map
- reduce
- filter
- sort
terminal
- forEach
- collect
- reduce
- count
Stream operations are useful because they allow any collection to be functionally manipulated and are efficient when processing large data.
# 3. What is reflection?
A reflection allows a program to inspect or modify its own code (classes, methods, fields constructors).
# 4. How to call the method using reflection?
Get the class with object.getClass
Get the method with getMethod
Run the method with Method.invoke()
# 5. How to create objects from reflection?
Get the class object with object.getClass
Get the constructor with getConstructor()
Create the object using Constructor.newInstance()
