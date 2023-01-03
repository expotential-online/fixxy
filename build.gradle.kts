plugins {
    kotlin("jvm") version "1.7.21"
    jacoco
}

allprojects {
    group = "expotential-online"
    version = "0.0.1-SNAPSHOT"
}

repositories {
    mavenCentral()
}

tasks {
    test {
        useJUnitPlatform()
    }

    jacocoTestReport {
        reports {
            xml.required.set(false)
            csv.required.set(false)
            html.required.set(true)
            html.outputLocation.set(file("$buildDir/jacocoHtml"))
        }
    }
}
