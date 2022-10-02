package sobaya.app.features

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform