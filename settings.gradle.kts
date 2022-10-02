pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sample202209"
include(":androidApp")
include(":shared")
include(":repository")
include(":network")
include(":util")
include(":usecase")
include(":data")
include(":randomDog")
include(":local")
include(":features")
