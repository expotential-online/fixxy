plugins {
  kotlin("jvm")
  id("org.sonarqube")
  jacoco
}

group = "expotential-online"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.jacocoTestReport {
  reports.xml.required.set(true)
}

tasks.withType<Test> {
  useJUnitPlatform()
}

