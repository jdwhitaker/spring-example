FROM tomcat:9.0

ADD ./target/java-example.war /usr/local/tomcat/webapps/ROOT.war