pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
//sdfsdf

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ChallengeArena"
include(":app")
include(":core")
include(":feature:auth")
include(":feature:network")
include(":feature:login")
include(":feature:splash")
include(":feature:home")
include(":feature:profile")
include(":feature:challenges")
include(":feature:achievements")
