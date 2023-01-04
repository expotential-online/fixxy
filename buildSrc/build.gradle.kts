plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencies {
  // See https://stackoverflow.com/questions/72048099/how-to-apply-kotlin-jvm-gradle-plugin-from-a-buildsrc-shared-gradle-script
  implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.8.0")
  // See https://stackoverflow.com/questions/45126215/plugin-with-id-org-sonarqube-not-found
  runtimeOnly("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.3")
}