// Product Class

class Product {

    constructor(name, price) {
        this.name = name;
        this.price = price;
    }
}


// Cart Class

class Cart {

    constructor() {
        this.items = [];
    }

    addItem(product, quantity) {

        this.items.push({
            product,
            quantity
        });

        console.log(
            product.name + " added to cart"
        );
    }

    removeItem(productName) {

        this.items = this.items.filter(
            item => item.product.name !== productName
        );

        console.log(
            productName + " removed"
        );
    }

    calculateTotal() {

        let total = 0;

        this.items.forEach(item => {

            total +=
                item.product.price * item.quantity;
        });

        return total;
    }

    applyCoupon(code) {

        let total = this.calculateTotal();

        if (code === "SAVE10") {

            total = total - total * 0.10;

            console.log("10% Discount Applied");
        }

        console.log("Final Total:", total);
    }

    showCart() {

        console.log("Cart Items:");

        this.items.forEach(item => {

            console.log(
                item.product.name +
                " x " +
                item.quantity
            );
        });
    }
}


// ------------------ TEST ------------------

let p1 = new Product(
    "Laptop",
    50000
);

let p2 = new Product(
    "Phone",
    20000
);

let cart = new Cart();

cart.addItem(p1, 1);

cart.addItem(p2, 2);

cart.showCart();

console.log(
    "Total:",
    cart.calculateTotal()
);

cart.applyCoupon("SAVE10");

cart.removeItem("Phone");

cart.showCart();