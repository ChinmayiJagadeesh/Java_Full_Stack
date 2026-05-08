// Question 1: Inheritance + super

class Person {

    constructor(name) {
        this.name = name;
    }
}

class Student extends Person {

    constructor(name, marks) {
        super(name);
        this.marks = marks;
    }

    showDetails() {
        console.log("Name: " + this.name + ", Marks: " + this.marks);
    }
}

let s1 = new Student("John", 90);

s1.showDetails();


// --------------------------------------------
// Question 2: Method Overriding with super

class Animal {

    eat() {
        console.log("Animal eats food");
    }
}

class Dog extends Animal {

    eat() {
        super.eat();
        console.log("Dog eats bones");
    }
}

let d1 = new Dog();

d1.eat();


// --------------------------------------------
// Question 3: Encapsulation with Validation

class User {

    #password;

    setPassword(pass) {

        if (pass.length >= 6) {
            this.#password = pass;
        } else {
            console.log("Password too short");
        }
    }

    getPassword() {
        return this.#password;
    }
}

let u1 = new User();

u1.setPassword("123");

u1.setPassword("abcdef");

console.log(u1.getPassword());


// --------------------------------------------
// Question 4: Abstraction + Private Method

class Laptop {

    #bootSystem() {
        console.log("Booting system...");
    }

    start() {
        this.#bootSystem();
        console.log("Laptop started");
    }
}

let l1 = new Laptop();

l1.start();