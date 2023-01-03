plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}