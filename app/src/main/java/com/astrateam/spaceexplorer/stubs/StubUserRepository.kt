package com.astrateam.spaceexplorer.stubs

import com.astrateam.spaceexplorer.domain.IUserRepository

class StubUserRepository : IUserRepository {
    override suspend fun loadTodayImage(): String {
        return "https://avatanplus.ru/files/resources/mid/5a3a22ba2b2e11607317a741.jpg"
    }
}