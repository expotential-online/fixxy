plugins {
  id("fixxy-kotlin-conventions")
}

dependencies {
  implementation("org.quickfixj:quickfixj-core:2.3.1")
  implementation("org.quickfixj:quickfixj-messages-fix42:2.3.1")
  testImplementation(kotlin("reflect"))
}

sonarqube {
  properties {
    property( "sonar.projectKey", "expotential-online:fixxy.core")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}