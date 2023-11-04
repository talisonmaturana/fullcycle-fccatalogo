FROM openjdk:11-jdk

ENV GRADLE_VERSION 7.2
ENV GRADLE_HOME /usr/local/gradle

# Install wget and unzip
RUN apt-get update && apt-get install -y wget unzip

# Download and install Gradle
RUN wget --no-verbose "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -P /tmp \
    && unzip -d /usr/local /tmp/gradle-${GRADLE_VERSION}-bin.zip \
    && ln -s /usr/local/gradle-${GRADLE_VERSION} $GRADLE_HOME \
    && rm /tmp/gradle-${GRADLE_VERSION}-bin.zip

# Add Gradle to the PATH
ENV PATH=$PATH:$GRADLE_HOME/bin

# Set the working directory
WORKDIR /app

CMD ["sh", "run.sh"]