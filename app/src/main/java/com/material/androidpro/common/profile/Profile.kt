package com.material.androidpro.common.profile

class Profile(var image: Int, var name: String) {

    var shortDes = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Profile

        if (image != other.image) return false
        if (name != other.name) return false
        if (shortDes != other.shortDes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = image
        result = 31 * result + name.hashCode()
        result = 31 * result + shortDes.hashCode()
        return result
    }


}