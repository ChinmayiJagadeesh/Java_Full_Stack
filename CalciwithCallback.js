// Calculator function

function calculate(a, b, callback) {

    let result = a + b;

    callback(result);
}

// Callback function

function display(result) {

    console.log("Result:", result);
}

// Function call

calculate(10, 5, display);