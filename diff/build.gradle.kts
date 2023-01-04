plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("com.google.guava:guava:31.1-jre")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}