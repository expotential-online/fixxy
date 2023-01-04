plugins {
  id("fixxy-kotlin-conventions")
}

dependencies {
  implementation(project(":core"))
  implementation("com.google.guava:guava:31.1-jre")
  implementation("org.quickfixj:quickfixj-core:2.3.1")
  implementation("org.quickfixj:quickfixj-messages-all:2.3.1")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
}

sonarqube {
  properties {
    property( "sonar.projectKey", "expotential-online:fixxy.quickfix")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}