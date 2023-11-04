#!/bin/bash

# Ensure Gradle home is set
export GRADLE_USER_HOME=/app/.gradle

# Run your Gradle commands
gradle --stop
gradle build --continuous --quiet &
gradle bootRun -Pdebug