# Topic 5 Notes

collections added 

- hashmap with productMap, cart, and inventory

- list implemented with custom linked list implementation

- arraylist with getProductsAsList() in productMap

- vector and priority queue for sorting functionality in inventory

# 1. What is generic?
A generic type is a generic class or interface that is parameterized over types.
# 2. How we can extend generic class, interface?
We can extend generic class, interface by specifying the type parameter in the class or interface declaration.
# 3. What is collection hierarchy?
The Collection interface is the root interface of the Java Collections Framework that implements Iterable. 
It is the topmost interface of the Collection framework.
# 4. What are the differences between Set, List, Queue, Map?
- Set: A Set is a collection that cannot contain duplicate elements.
- List: A List is an ordered collection that can contain duplicate elements.
- Queue: A Queue is a collection that represents an ordered list of object accessed by FIFO (First In, First Out) manner.
- Map: A Map is an object that maps keys to values.
# 5. How we can iterate the Map?
We can iterate the map using values(), keySet(), entrySet() or using Iterator.
# 6. What do you know about collections with Hash?
Hash collections maintain buckets to store objects and use hashcode to store and retrieve objects.
# 7. Why do we need Iterable interface?
The Iterable interface is used to represent a collection of objects that can be iterated over. 
All collection classes in Java implement the Iterable interface.
# 8. What is collision? How to handle that?
A collision occurs when two different keys have the same hashcode.
We can handle collisions by using separate chaining or open addressing.
# 9. What do you know about threadsafe collections?
Thread-safe collections are collections that are designed to be used and be safe in a multi-threaded environment.
