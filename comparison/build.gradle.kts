plugins {
  id("fixxy-kotlin-conventions")
}

dependencies {
  implementation(project(":core"))
  implementation("com.google.guava:guava:31.1-jre")
}

sonarqube {
  properties {
    property( "sonar.projectKey", "expotential-online:fixxy.comparison")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}