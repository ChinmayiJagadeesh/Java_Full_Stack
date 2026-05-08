fetch("https://jsonplaceholder.typicode.com/posts")
    .then((response) => response.json())
    .then((data) => {
        data.forEach((post) => {
            console.log(post.title);
        });
    })
    .catch((error) => {
        console.log("Error:", error);
    });