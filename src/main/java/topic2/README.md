# Topic 2 Questions

# Why do we need OOP?
Object Oriented Programming helps programmers break complex coding problems into manageable sub-problems, by having a structure and hierarchy.
# What problem does it solve?
OOP solves the problem of managing complexity and making code more reusable maintainable, and scalable.
# What are the 3 main OOP approaches?
Encapsulation, Inheritance, Polymorphism
# What is encapsulation?
Encapsulation is the process of Hiding the internal state and requiring all interaction through an object's methods.
# What is inheritance?
Inheritance is the process of subclasses inheriting the properties and methods of a super class.
# What is an abstract class?
An abstract class is a class that cannot be initiated on its own but can be used as a super class.
# What is an abstract method?
An abstract method is a method in an abstract class that is not defined and is meant to be implemented in the sub class.
# What is a constructor?
A constructor is the method that initializes the class and the class states when the class object is created.
# What is a default constructor, and why do we need them?
A default constructor does not take in any initial parameters and defines the class states to default values. We need them if we want to define the class without knowing the initial values of the class's state.
# What modifiers do you know?
access modifiers - public, protected, default, private
non access modifiers - static, final, abstract
# What are the differences between them?
the access modifiers control the visibility of classes, methods, and fields
static - allows a method to belong to a class rather than an instance
final - disallows a subclass from overriding
abstract - cannot create an instance of the class
# What do you know about the Object class?
Every class is a subclass of the Object class. It has methods like equals, toString, and hashCode that can be overridden.
# How is the hashCode method connected with equals?
If two objects are equal using the equal function then they must have the same hash code.
# What is the difference between Overloading and Overriding
Overloading is when a class has multiple methods with the same name but uses different parameter lists.
Overriding is when a subclass overrides a method in the super class defining it as its own.
