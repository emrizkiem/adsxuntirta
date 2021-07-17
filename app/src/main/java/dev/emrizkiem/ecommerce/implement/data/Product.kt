package dev.emrizkiem.ecommerce.implement.data

class Product {
    var name: String? = ""
    var description: String? = ""
    var price: Int? = 0
    var thumbnail: String? = ""

    constructor(){}

    constructor(name: String?, description: String?, price: Int?, thumbnail: String?) {
        this.name = name
        this.description = description
        this.price = price
        this.thumbnail = thumbnail
    }
}
