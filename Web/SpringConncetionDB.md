# Spring 과 DB연동을 위한 코드

#### mybatis와 JDBC 라이브러리를 위한 pom.xml

```xml
	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis</artifactId>
		<version>3.1.0</version>
	</dependency>
	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis-spring</artifactId>
		<version>1.1.0</version>
	</dependency>
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.29</version>
	</dependency>
	<dependency>
		<groupId>jdbc.oracle</groupId>
		<artifactId>OracleDriver</artifactId>
		<version>12.1.0.2.0</version>
		<scope>system</scope>
		<systemPath>${basedir}/src/main/webapp/WEB-INF/lib/ojdbc6.jar</systemPath>
	</dependency>
```


#### Spring F/W와 DB간의 연결을 위한 action-mybatis.xml 파일

```xml
<beans
 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd"
 xmlns:tx="http://www.springframework.org/schema/tx" xmlns:context="http://www.springframework.org/schema/context"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.springframework.org/schema/beans">
 
<!-- 연동시킬 DB의 정보를 담는 properties파일 연결 -->
<bean id="propertyPlaceholderConfigurer"
class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
<property name="locations">
<value>/WEB-INF/config/jdbc/jdbc.properties</value>
</property>
</bean>

<!-- Connection pool을 만듬 이유는 대여,반납을 위해 생성한다 -->
<bean id="dataSource" class="org.apache.ibatis.datasource.pooled.PooledDataSource">
	<property name="driver" value="${jdbc.driverClassName}" />
	<property name="url" value="${jdbc.url}" />
	<property name="username" value="${jdbc.username}" />
	<property name="password" value="${jdbc.password}" />
</bean>
<!-- sqlSessionFactory를 생성해 query문이 작성된 xml파일을 명시 -->
<bean id="sqlSessionFactory"
	class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource" />
	<property name="configLocation"
		value="classpath:mybatis/model/modelConfig.xml" />
	<property name="mapperLocations" value="classpath:mybatis/mappers/*.xml" />
</bean>

<!-- sqpSeeion을 통해 sqlSessionFactory를 접근할 수 있도록 작성한다. -->
<bean id="sqlSession"
	class="org.mybatis.spring.SqlSessionTemplate">
	<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
</bean>
<!-- <bean id="memberDAO"
	class="com.spring.member.dao.MemberDAOImpl">
	<property name="sqlSession" ref="sqlSession"></property>
</bean> -->
</beans>
```



#### db서버의 정보를 담는 JDBC.properties 파일

```properties
jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
jdbc.username=hr
jdbc.password=1234
```



#### VO타입의 경로에 별칭을 만들어 간결하게 타입 입력

- mc.sn.member.vo.MemberVO의 타입 경로를 일일이 추가해주면 매우매우 불편하기 때문에 alias로 간결하게 만들어 주기!!
- action-mybatis.xml파일 중 sqlSessionFactory 빈을 생성할 때 입력하는 놈의 파일 내용이다!
  - <property name="configLocation"
    		value="classpath:mybatis/model/modelConfig.xml"/>
- modelConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration 	PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<typeAliases>
		<typeAlias type="mc.sn.member.vo.MemberVO"  alias="memberVO" />
	</typeAliases>
</configuration>
```



#### Query문을 작성하고 이를 통해 DB에 저장된 Table에서 CRUD역할을 수행하는 query문.xml파일

- action-mybatis.xml파일 중 sqlSessionFactory 빈을 생성할 때 입력하는 놈의 파일 내용이다!
  - <property name="mapperLocations" value="classpath:mybatis/mappers/*.xml" />

- *.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
      PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="mapper.member">
	<resultMap id="memResult" type="memberVO">
		<result property="id" column="id" />
        <result property="pwd" column="pwd" />
        <result property="name" column="name" />
        <result property="email" column="email" />
        <result property="joinDate" column="joinDate" />
	</resultMap> 
	<!-- 
	<resultMap id="memResult" type="java.util.HashMap">
      <result property="id" column="id" />
      <result property="pwd" column="pwd" />
      <result property="name" column="name" />
      <result property="email" column="email" />
      <result property="joinDate" column="joinDate" />
   </resultMap> -->


	<select id="selectAllMemberList" resultMap="memResult">
      <![CDATA[
         select * from t_member	order by joinDate desc	 	
      ]]>
	</select>
    
     <insert id="insertMember"  parameterType="memberVO">
		<![CDATA[
		 insert into t_member(id,pwd, name, email)
		 values(#{id}, #{pwd}, #{name}, #{email})
		]]>      
	</insert>
	
   
   <update id="updateMember"  parameterType="memberVO">
     <![CDATA[
	     update t_member
	     set pwd=#{pwd}, name=#{name}, email=#{email}
	     where
	     id=#{id}
      ]]>      
   </update> 
     
   <delete id="deleteMember"  parameterType="String">
	<![CDATA[
	   delete from  t_member
	   where
	   id=#{id}
	]]>      
  </delete>
  <select id="loginById"  resultType="memberVO" >
	<![CDATA[
		select * from t_member	
		where id=#{id} and pwd=#{pwd}
	]]>
  </select>
</mapper>
```

