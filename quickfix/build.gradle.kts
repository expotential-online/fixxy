plugins {
    kotlin("jvm") version "1.7.21"
    id("org.sonarqube") version "3.5.0.2730"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.quickfixj:quickfixj-core:2.3.1")
    implementation("org.quickfixj:quickfixj-messages-all:2.3.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sonarqube {
    properties {
        property("sonar.projectKey", "expotential-online_fixxy")
        property("sonar.organization", "expotential-online")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}