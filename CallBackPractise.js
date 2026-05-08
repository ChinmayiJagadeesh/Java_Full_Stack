function processNumber(num, callback) {

    let result = num * 2;

    callback(result);
}

function printResult(value) {

    console.log("Result:", value);
}

processNumber(5, printResult);