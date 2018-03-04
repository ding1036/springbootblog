### environment
java 9
gradle 4.6
spring boot 2.0
idea
Ubuntu

### install gradle
You can follow below blog to install gradle:<br/>
[gradle blog](http://blog.csdn.net/stwstw0123/article/details/47809189)

### change respository to Aliyun respository to speed up download speed
Add following code at repositories block in bulid.gradle:<br/>
```
maven {url 'http://maven.aliyun.com/nexus/content/groups/public/'}
```