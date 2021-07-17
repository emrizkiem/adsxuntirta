package dev.emrizkiem.ecommerce.implement.data

class Category {
    var name: String? = ""
    var image: String? = ""

    constructor(){}

    constructor(name: String?, image: String?) {
        this.name = name
        this.image = image
    }
}
