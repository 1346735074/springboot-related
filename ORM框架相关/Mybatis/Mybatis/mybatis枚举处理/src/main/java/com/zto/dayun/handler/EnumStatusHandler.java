package com.zto.dayun.handler;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zto.dayun.enums.EnumStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 16:09
 * @Description: mybatis类型处理器
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class EnumStatusHandler extends BaseTypeHandler<EnumStatus> { //如果不用泛型，可以加@MappedTypes注释来匹配需要被拦截的Java类型

    private Class<EnumStatus> type;

    public EnumStatusHandler(){};

    public EnumStatusHandler(Class<EnumStatus> type) {
        if (type == null) throw new IllegalArgumentException("类型参数不能为空");
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumStatus parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getCode());
    }
    //查询执行
    @Override
    public EnumStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getInt(columnName));
    }

    @Override
    public EnumStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getInt(columnIndex));
    }

    @Override
    public EnumStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getInt(columnIndex));
    }

    /**
     * 转换
     * @param status
     * @return
     */
    private EnumStatus convert(int status){
        EnumStatus[] objs = type.getEnumConstants();
        for(EnumStatus em: objs){
            if(em.getCode().equals(status)){
                return  em;
            }
        }
        return null;
    }

    /**
     * 根据code获取去value
     * @param c 枚举类型.class
     * @param code 枚举key
     * @param <E> 枚举类型
     * @param <K> key类型
     * @return
     */
    public static<E extends Enum<E>, K> Object getVelByCode(Class<E> c, K code){
        try {
            Class<E> class1 = (Class<E>) Class.forName(c.getCanonicalName());//加载类
            EnumStatus[] rest  = (EnumStatus[]) class1.getMethod("values").invoke(new Object());//获取values方法执行

            //获取get方法
            List<Method> methods = new ArrayList<>();
            Field[] fields = class1.getDeclaredFields();//获得属性
            for (Field field : fields) {
                if (field.getType().getName().equals(class1.getName()))continue;//为枚举里的值重新执行
                if (field.getName().equals("$VALUES"))continue;//为$VALUES重新执行
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), class1,field.getName(),null);	//获得get方法
                Method getMethod = pd.getReadMethod();//执行get方法返回一个Object
                methods.add(getMethod);
            }
            if (!methods.get(0).getReturnType().equals(code.getClass())){
                throw new IllegalArgumentException("枚举参数类型("+methods.get(0).getReturnType()
                        +")和指定参数类型("+code.getClass()+")不匹配");
            }
            //比对
            for(EnumStatus platformFree:rest){
                if(code.equals(methods.get(0).invoke(platformFree))){
                    return methods.get(1).invoke(platformFree);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + c.getSimpleName());
    }

}