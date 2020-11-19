package com.example.texts.ModelClasses

class Users {
    private var uid: String = ""
    private var profile: String = ""
    private var search: String = ""
    private var status: String = ""
    private var username: String = ""
    private var bio: String = ""

    constructor()

    constructor(uid: String, profile: String, search: String, status: String, username: String, bio: String) {
        this.uid = uid
        this.profile = profile
        this.search = search
        this.status = status
        this.username = username
        this.bio = bio
    }

    fun getUid(): String?{
        return uid
    }
    fun setUid(uid: String){
        this.uid = uid
    }

    fun getUsername(): String?{
        return username
    }
    fun setUsername(username: String){
        this.username = username
    }

    fun getProfile(): String?{
        return profile
    }
    fun setProfile(profile: String){
        this.profile = profile
    }

    fun getStatus(): String?{
        return status
    }
    fun setStatus(status: String){
        this.status = status
    }

    fun getSearch(): String?{
        return search
    }
    fun setSearch(search: String){
        this.search = search
    }

    fun getBio(): String?{
        return bio
    }
    fun setBio(bio: String){
        this.bio = bio
    }
}