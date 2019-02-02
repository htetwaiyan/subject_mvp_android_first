package com.example.htetwaiyan.mymvp.model


class Subject {
    var updated_at: String? = null

    var name: String? = null

    var created_at: String? = null

    var del_status: String? = null

    var id: String? = null

    override fun toString(): String {
        return "ClassPojo [updated_at = $updated_at, name = $name, created_at = $created_at, del_status = $del_status, id = $id]"
    }
}