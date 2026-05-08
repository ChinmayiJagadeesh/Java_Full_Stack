function getData() {
    return new Promise((resolve, reject) => {
        let success = false;

        if (success) {
            resolve("Data received");
        } else {
            reject("Error");
        }
    });
}

async function fetchData() {
    try {
        let result = await getData();
        console.log(result);
    } catch (error) {
        console.log("Something went wrong");
    }
}

fetchData();