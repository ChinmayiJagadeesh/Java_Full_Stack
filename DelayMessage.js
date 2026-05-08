// Async callback with setTimeout

function delayedMessage(callback) {

    setTimeout(function () {

        callback();

    }, 2000);
}

// Callback function

function showMessage() {

    console.log("Message after 2 seconds");
}

// Function call

delayedMessage(showMessage);