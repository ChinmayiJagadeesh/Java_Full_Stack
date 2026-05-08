// Greeting function

function greet(name, callback) {

    callback(name);
}

// Callback function

function message(userName) {

    console.log("Hello " + userName);
}

// Function call

greet("John", message);