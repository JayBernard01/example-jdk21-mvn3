# to install java on linux (ubuntu) -> make sure to use jdk-21 and maven-3

```bash
java --version
mvn --version
# install if version is not present
sudo apt update
sudo apt install openjdk-21-jdk
sudo apt install maven
```

# to exec java code:
```bash
mvn install
mvn exec:java
```

# note for wsl with intellij
deactivate threat protection to update maven dependencies, then turn back on after on each load 
