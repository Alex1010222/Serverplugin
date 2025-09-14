import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    kotlin("jvm") version "2.2.0"
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("de.eldoria.plugin-yml.paper") version "0.7.1"
}

group = "de.alex_mhr"
version = "0.1-alpha"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.7-R0.1-SNAPSHOT")
    compileOnly("dev.jorel:commandapi-bukkit-core:10.1.1")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.11.2")
}

paper {
    main = "de.alex_mhr.serverplugin.Serverplugin"
    apiVersion = "1.21"
    name = "Serverplugin"
    author = "Alex_mhr"

    serverDependencies {
        register("CommandAPI") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }

}

tasks {
    runServer {
        minecraftVersion("1.21.7")

        downloadPlugins {
            hangar("commandapi", "10.1.1")
        }
    }

    shadowJar {
        relocate("com.github.stefvanschie.inventoryframework", "de.alex_mhr.serverplugin.libs.if")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

