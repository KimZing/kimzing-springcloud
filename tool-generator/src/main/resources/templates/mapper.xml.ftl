<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">
<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
</#if>
<#if baseColumnList>
    <sql id="all_column"><#list table.commonFields as field>${field.columnName},</#list>${table.fieldNames?replace(" ","")}</sql>
</#if>
<#if baseColumnList>
    <sql id="po_column">${table.fieldNames?replace(" ","")}</sql>
</#if>

    <insert id="insert" useGeneratedKeys="true" keyColumn="id" keyProperty="id">

    </insert>

    <update id="update">

    </update>

    <delete id="delete">

    </delete>

    <select id="select" resultType="${package.Entity}.${table.name?cap_first}BO">

    </select>

    <select id="selectPage" resultType="${package.Entity}.${table.name?cap_first}BO">

    </select>

<#if baseResultMap>
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
    </resultMap>

</#if>
</mapper>
