let checkNumber = new Promise((resolve, reject) => {
    let num = 15;

    if (num > 10) {
        resolve("Success");
    } else {
        reject("Fail");
    }
});

checkNumber
    .then((result) => {
        console.log(result);
    })
    .catch((error) => {
        console.log(error);
    });