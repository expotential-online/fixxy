plugins {
  kotlin("jvm")
  id("org.sonarqube")
}

group = "expotential-online"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
