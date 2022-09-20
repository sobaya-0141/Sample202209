package sobaya.app.sample202209

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform