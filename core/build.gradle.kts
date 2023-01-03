plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.quickfixj:quickfixj-core:2.3.1")
    implementation("org.quickfixj:quickfixj-messages-fix42:2.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(kotlin("reflect"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}