add cacert to keystore

/Library/Java/JavaVirtualMachines/jdk-15.0.2.jdk/Contents/Home/lib/security

/Library/Java/JavaVirtualMachines/jdk-15.0.2.jdk/Contents/Home/bin

keytool -importcert -trustcacerts -cacerts -alias pgca -file /Users/joeqiao/Documents/LocalHub/credential/PGRootCA.pem 
keytool -importcert -trustcacerts -cacerts -alias zscalerca -file /Users/joeqiao/Documents/LocalHub/credential/ZscalerRootCA.pem
/Users/joeqiao/Documents/LocalHub/credential/PG Root CA.cer
/Users/joeqiao/Documents/LocalHub/credential/PG Root CA.pem
/Users/joeqiao/Documents/LocalHub/credential/PGRootCA.pem