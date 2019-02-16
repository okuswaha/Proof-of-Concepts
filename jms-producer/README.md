create mvn project :
mvn archetype:generate -DgroupId=com.prakash.jmsmq -DartifactId=jms-producer -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

add spring boot support : 
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <type>pom</type>
      <version>2.0.2.RELEASE</version>
      <scope>import</scope>
    </dependency>
    
add above to dependencies

add oracle aq and jdbc dependency:

<dependency>
    <groupId>com.oracle.aqapi</groupId>
    <artifactId>aqapi</artifactId>
    <version>1.0</version>
</dependency>
<dependency>
    <groupId>oracle</groupId>
    <artifactId>ojdbc6</artifactId>
    <version>11.2.0.4.0</version>
</dependency>
        
add rest support 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
          <version>2.0.2.RELEASE</version>

</dependency>

mvn build plug in 
<build>
   <plugins>
     <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
       <version>2.0.2.RELEASE</version>
       <executions>
         <execution>
           <goals>
             <goal>repackage</goal>
           </goals>
         </execution>
       </executions>
     </plugin>
   </plugins>
 </build>

<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <version>2.0.2.RELEASE</version>
</dependency>

            
            