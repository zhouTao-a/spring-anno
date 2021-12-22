package com.allen.utils;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义BeanNameGenerator
 */
public class CustomBeanNameGenerator implements BeanNameGenerator {

    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";

    private final Map<String, Set<String>> metaAnnotationTypesCache = new ConcurrentHashMap<>();

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        //定义Bean的名称
        String beanName = null;
        //1、判断当前bean的定义信息是否是注解的
        if (definition instanceof AnnotatedBeanDefinition) {
            //2、把definition转成bean注解的定义信息
            AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) definition;
            //3、获取注解bean定义的元信息
            AnnotationMetadata annotationMetadata = annotatedBeanDefinition.getMetadata();
            //4、获取定义信息中的所有注释
            Set<String> types = annotationMetadata.getAnnotationTypes();
            //5、遍历types集合
            for(String type : types) {
                //6、得到注解的属性
                AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(type, false));
                //7、判断attributes是否为null，同时必须是@Component及其衍生注解
                if (attributes != null) {
                    Set<String> metaTypes = this.metaAnnotationTypesCache.computeIfAbsent(type, key -> {
                        Set<String> result = annotationMetadata.getMetaAnnotationTypes(key);
                        return (result.isEmpty() ? Collections.emptySet() : result);
                    });
                    if (isStereotypeWithNameValue(type, metaTypes, attributes)) {
                        //8、获取属性value的值
                        Object value = attributes.get("value");
                        //9、判断value属性是否为String类型
                        if (value instanceof String) {
                            String strVal = (String) value;
                            //10、判断value属性是否有值
                            if (StringUtils.hasLength(strVal)) {
                                if (beanName != null && !strVal.equals(beanName)) {
                                    throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                            "component names: '" + beanName + "' versus '" + strVal + "'");
                                }
                                beanName = strVal;
                            }
                        }
                    }
                }

            }
        }
        return beanName != null ? "my" + beanName : "my" + buildDefaultBeanName(definition);
    }

    private boolean isStereotypeWithNameValue(String annotationType,
                                                Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    private String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
