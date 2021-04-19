package com.astrateam.spaceexplorer.domain

interface IUserRepository {
    suspend fun loadTodayImage() : String
}