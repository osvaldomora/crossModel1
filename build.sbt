libraryDependencies ++= Seq(
javaJdbc,
javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
"org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final"
)
